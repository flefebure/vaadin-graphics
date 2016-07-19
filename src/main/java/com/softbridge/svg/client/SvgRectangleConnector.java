package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.SvgRectangle;
import com.softbridge.svg.shared.SvgRectangleState;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.gwtgraphics.client.shape.Rectangle;

@Connect(SvgRectangle.class)
public class SvgRectangleConnector extends SvgShapeConnector {
    @Override
    protected Rectangle createWidget() {
        return new Rectangle(0,0,0,0);
    }
    @Override
    public Rectangle getWidget() {
        return (Rectangle) super.getWidget();
    }
    @Override
    public SvgRectangleState getState() {
        return (SvgRectangleState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setRoundedCorners(getState().roundedCornersRadius);
    }
}
