package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.SvgDrawingArea;
import com.softbridge.svg.shared.SvgDrawingAreaState;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentContainerConnector;
import com.vaadin.shared.Connector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.Group;
import org.vaadin.gwtgraphics.client.VectorObject;

@Connect(SvgDrawingArea.class)
public class SvgDrawingAreaConnector extends AbstractComponentContainerConnector {
    @Override
    protected DrawingArea createWidget() {
        DrawingArea drawingArea = new DrawingArea(0,0);
        return drawingArea;

    }
    @Override
    public DrawingArea getWidget() {
        return (DrawingArea) super.getWidget();
    }
    @Override
    public SvgDrawingAreaState getState() {
        return (SvgDrawingAreaState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {

        super.onStateChanged(stateChangeEvent);
        updateComponentSize(getState().width, getState().height);

        getWidget().clear();
        for (Connector connector : getState().vectorObjects) {
            if (connector == null) continue;
            if (connector instanceof SvgGroupConnector) {
                SvgGroupConnector SvgGroupConnector = (SvgGroupConnector)connector;
                Group group = SvgGroupConnector.getWidget();
                getWidget().add(group);
            }
            else {
                SvgVectorObjectConnector svgVectorObjectConnector = (SvgVectorObjectConnector) connector;
                VectorObject vectorObject = svgVectorObjectConnector.getWidget();
                getWidget().add(vectorObject);
            }
        }

    }

    @Override
    protected void updateComponentSize(String newWidth, String newHeight) {
        getWidget().setWidth(SvgConnectorUtils.correctSize(newWidth));
        getWidget().setHeight( SvgConnectorUtils.correctSize(newHeight));
    }

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {

    }

    @Override
    public void updateCaption(ComponentConnector connector) {

    }
}
