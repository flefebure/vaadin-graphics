package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.SvgCircle;
import com.softbridge.svg.shared.SvgCircleState;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import org.vaadin.gwtgraphics.client.shape.Circle;
import org.vaadin.gwtgraphics.client.shape.Rectangle;

@Connect(SvgCircle.class)
public class SvgCircleConnector extends SvgShapeConnector {
    @Override
    protected Circle createWidget() {
        return new Circle(0, 0, 0);
    }
    @Override
    public Circle getWidget() {
        return (Circle) super.getWidget();
    }
    @Override
    public SvgCircleState getState() {
        return (SvgCircleState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setRadius(getState().radius);
    }
    @Override
    protected void updateComponentSize(String newWidth, String newHeight) {
    }
}
