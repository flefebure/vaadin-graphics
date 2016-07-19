package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Widget;
import com.softbridge.svg.shared.SvgVectorObjectState;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.MouseEventDetails;
import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.Group;
import org.vaadin.gwtgraphics.client.VectorObject;

public abstract class SvgVectorObjectConnector extends AbstractComponentConnector {

    SvgVectorObjectClickListener svgVectorObjectClickListener = RpcProxy
            .create(SvgVectorObjectClickListener.class, this);


    public SvgVectorObjectConnector() {

        registerRpc(SvgVectorObjectBringToFrontListener.class, new SvgVectorObjectBringToFrontListener() {
            public void bringToFront() {
                Widget parent = getWidget().getParent();
                if (parent instanceof DrawingArea) {
                    DrawingArea drawingArea = (DrawingArea)parent;
                    drawingArea.bringToFront(getWidget());
                }
                else if (parent instanceof Group) {
                    Group group = (Group)parent;
                    group.bringToFront(getWidget());
                }
            }
        });

        getWidget().addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

                final MouseEventDetails mouseDetails = MouseEventDetailsBuilder
                        .buildMouseEventDetails(event.getNativeEvent(),
                                getWidget().getElement());

                svgVectorObjectClickListener.clicked(mouseDetails);
            }
        });
    }

    @Override
    public VectorObject getWidget() {
        return (VectorObject) super.getWidget();
    }
    @Override
    public SvgVectorObjectState getState() {
        return (SvgVectorObjectState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        updateComponentSize(getState().width, getState().height);
        getWidget().setRotation(getState().rotation);

    }

    @Override
    protected void setWidgetStyleName(String styleName, boolean add) {}

    @Override
    protected void updateWidgetStyleNames() {}
    
    @Override
    protected void updateComponentSize(String newWidth, String newHeight) {
        getWidget().setWidth(SvgConnectorUtils.correctSize(newWidth));
        getWidget().setHeight( SvgConnectorUtils.correctSize(newHeight));
    }



}
