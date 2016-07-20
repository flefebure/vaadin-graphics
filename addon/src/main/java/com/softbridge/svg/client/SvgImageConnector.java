package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.shared.SvgImageState;
import com.softbridge.svg.SvgImage;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import org.vaadin.gwtgraphics.client.Image;
import org.vaadin.gwtgraphics.client.Line;

@Connect(SvgImage.class)
public class SvgImageConnector extends SvgVectorObjectConnector {
    @Override
    protected Image createWidget() {
        return new Image(0,0,0,0,"");
    }
    @Override
    public Image getWidget() {
        return (Image) super.getWidget();
    }
    @Override
    public SvgImageState getState() {
        return (SvgImageState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setX(getState().x);
        getWidget().setY(getState().y);
        getWidget().setHref(getState().href);
    }
}
