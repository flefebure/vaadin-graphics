package com.softbridge.svg;

import com.softbridge.svg.client.SvgVectorObjectClickListener;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * Created by franck.lefebure on 17/07/2016.
 */
@Theme("valo")
public class SvgTestUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = SvgTestUI.class, widgetset = "com.softbridge.svg.WidgetSet")

    public static class Servlet extends VaadinServlet {
    }

    SvgText addCircle;
    SvgText removeCircle;
    SvgCircle svgCircle;

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.addComponent(new Label("HelloWorld"));
        SvgDrawingArea svgDrawingArea = new SvgDrawingArea(1000,500);

        SvgRectangle svgRectangle1 = new SvgRectangle(50, 100, 100, 200);
        SvgPath svgPath = new SvgPath(200, 50);
        svgPath.lineTo(200, 450);
        svgRectangle1.setFillColor("#666666");
        svgRectangle1.setRoundedCornersRadius(10);

        SvgRectangle svgRectangle2 = new SvgRectangle(70, 120, 50, 50);
        svgRectangle2.setFillColor("red");

        SvgText bring1ToFront = new SvgText(10, 10, "bring grey rect to front");
        bring1ToFront.setFontSize(10);
        bring1ToFront.setSvgVectorObjectClickListener(mouseDetails1 -> {
            svgRectangle1.bringToFront();
        });

        SvgText bring2ToFront = new SvgText(10, 30, "bring red rect to front");
        bring2ToFront.setFontSize(10);
        bring2ToFront.setSvgVectorObjectClickListener(mouseDetails1 -> {
            svgRectangle2.bringToFront();
        });


        SvgEllipse svgEllipse = new SvgEllipse(550, 250, 100, 50);
        SvgText svgText = new SvgText(500, 250, "this is a group");
        svgText.setSvgVectorObjectClickListener(new SvgVectorObjectClickListener() {
            @Override
            public void clicked(MouseEventDetails mouseDetails) {
                Notification.show("click", "hello world has bee clicked", Notification.Type.TRAY_NOTIFICATION);
            }
        });

        SvgLine svgLine = new SvgLine(200,100,600,100);
        svgLine.setStrokeWidth(5);

        SvgGroup svgGroup = new SvgGroup();
        svgGroup.addVectorObject(svgEllipse);
        svgGroup.addVectorObject(svgText);

        SvgImage svgImage = new SvgImage(550, 300, 50, 50, "/static/clock.svg");

        svgDrawingArea.addVectorObject(svgRectangle1);
        svgDrawingArea.addVectorObject(svgRectangle2);
        svgDrawingArea.addVectorObject(svgPath);
        svgDrawingArea.addVectorObject(svgGroup);
        svgDrawingArea.addVectorObject(svgLine);
        svgDrawingArea.addVectorObject(svgImage);
        svgDrawingArea.addVectorObject(bring1ToFront);
        svgDrawingArea.addVectorObject(bring2ToFront);

        svgCircle = new SvgCircle(720,200, 20);
        svgCircle.setFillColor("red");

        addCircle = new SvgText(700, 100, "draw circle");
        addCircle.setSvgVectorObjectClickListener(mouseDetails -> {
            svgDrawingArea.addVectorObject(svgCircle);
            int index = svgDrawingArea.getSvgObjectIndex(addCircle);
            svgDrawingArea.setVectorObject(index, removeCircle);
        });
        removeCircle = new SvgText(700, 100, "remove circle");
        removeCircle.setSvgVectorObjectClickListener(mouseDetails -> {
            svgDrawingArea.removeVectorObject(svgCircle);
            int index = svgDrawingArea.getSvgObjectIndex(removeCircle);
            svgDrawingArea.setVectorObject(index, addCircle);
        });
        svgDrawingArea.addVectorObject(addCircle);
        layout.addComponent(svgDrawingArea);

        SvgText expandLine = new SvgText(250,150, "expand line");
        expandLine.setSvgVectorObjectClickListener(mouseDetails -> {
            svgLine.setX2(svgLine.getX2()+10);
        });
        svgDrawingArea.addVectorObject(expandLine);
    }
}
