package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.SvgText;
import com.softbridge.svg.shared.SvgTextState;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import org.vaadin.gwtgraphics.client.shape.Rectangle;
import org.vaadin.gwtgraphics.client.shape.Text;

@Connect(SvgText.class)
public class SvgTextConnector extends SvgShapeConnector {
    @Override
    protected Text createWidget() {
        return new Text(getState().x,getState().y,getState().text);
    }
    @Override
    public Text getWidget() {
        return (Text) super.getWidget();
    }
    @Override
    public SvgTextState getState() {
        return (SvgTextState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setFontFamily(getState().fontFamily);
        getWidget().setFontSize(getState().fontSize);
        getWidget().setText(getState().text);
    }
    @Override
    protected void updateComponentSize(String newWidth, String newHeight) {
    }
}
