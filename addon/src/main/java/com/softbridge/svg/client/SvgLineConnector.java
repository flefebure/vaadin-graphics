package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.SvgLine;
import com.softbridge.svg.shared.SvgLineState;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import org.vaadin.gwtgraphics.client.Line;
import org.vaadin.gwtgraphics.client.shape.Rectangle;

@Connect(SvgLine.class)
public class SvgLineConnector extends SvgVectorObjectConnector {
    @Override
    protected Line createWidget() {
        return new Line(0,0,0,0);
    }
    @Override
    public Line getWidget() {
        return (Line) super.getWidget();
    }
    @Override
    public SvgLineState getState() {
        return (SvgLineState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setX1(getState().x1);
        getWidget().setY1(getState().y1);
        getWidget().setX2(getState().x2);
        getWidget().setY2(getState().y2);
    }
    @Override
    protected void updateComponentSize(String newWidth, String newHeight) {
    }
}
