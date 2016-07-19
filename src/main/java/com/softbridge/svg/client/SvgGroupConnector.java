package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.SvgGroup;
import com.softbridge.svg.shared.SvgGroupState;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ConnectorHierarchyChangeEvent;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentContainerConnector;
import com.vaadin.shared.Connector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.Group;
import org.vaadin.gwtgraphics.client.VectorObject;

@Connect(SvgGroup.class)
public class SvgGroupConnector extends AbstractComponentContainerConnector {
    @Override
    protected Group createWidget() {
        Group group = new Group();
        return group;

    }
    @Override
    public Group getWidget() {
        return (Group) super.getWidget();
    }
    @Override
    public SvgGroupState getState() {
        return (SvgGroupState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {

        super.onStateChanged(stateChangeEvent);
        updateComponentSize(getState().width, getState().height);

        for (Connector connector : getState().vectorObjects) {
            if (connector == null) continue;
            SvgVectorObjectConnector svgVectorObjectConnector = (SvgVectorObjectConnector)connector;
            VectorObject vectorObject = svgVectorObjectConnector.getWidget();

            getWidget().add(vectorObject);
        }

    }

    @Override
    protected void updateComponentSize(String newWidth, String newHeight) {}

    @Override
    protected void setWidgetStyleName(String styleName, boolean add) {}
    @Override
    protected void updateWidgetStyleNames() {}

    @Override
    public void onConnectorHierarchyChange(ConnectorHierarchyChangeEvent connectorHierarchyChangeEvent) {

    }

    @Override
    public void updateCaption(ComponentConnector connector) {

    }
}
