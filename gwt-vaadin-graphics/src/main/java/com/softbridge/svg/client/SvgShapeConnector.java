package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.shared.SvgShapeState;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.gwtgraphics.client.Shape;
import org.vaadin.gwtgraphics.client.shape.Rectangle;

public abstract class SvgShapeConnector extends SvgVectorObjectConnector {

    @Override
    public Shape getWidget() {
        return (Shape) super.getWidget();
    }
    @Override
    public SvgShapeState getState() {
        return (SvgShapeState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {

        super.onStateChanged(stateChangeEvent);

        getWidget().setX(getState().x);
        getWidget().setY(getState().y);
        getWidget().setFillColor(getState().fillColor);
        getWidget().setStrokeColor(getState().strokeColor);
        getWidget().setFillOpacity(getState().fillOpacity);
        getWidget().setStrokeOpacity(getState().strokeOpacity);
        getWidget().setStrokeWidth(getState().strokeWidth);

    }

}
