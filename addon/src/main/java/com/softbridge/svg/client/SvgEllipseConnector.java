package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.SvgEllipse;
import com.softbridge.svg.shared.SvgEllipseState;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import org.vaadin.gwtgraphics.client.shape.Circle;
import org.vaadin.gwtgraphics.client.shape.Ellipse;

@Connect(SvgEllipse.class)
public class SvgEllipseConnector extends SvgShapeConnector {
    @Override
    protected Ellipse createWidget() {
        return new Ellipse(0, 0, 0, 0);
    }
    @Override
    public Ellipse getWidget() {
        return (Ellipse) super.getWidget();
    }
    @Override
    public SvgEllipseState getState() {
        return (SvgEllipseState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setRadiusX(getState().radiusX);
        getWidget().setRadiusY(getState().radiusY);
    }
    @Override
    protected void updateComponentSize(String newWidth, String newHeight) {
    }
}
