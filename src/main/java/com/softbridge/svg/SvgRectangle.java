package com.softbridge.svg;

/**
 * Created by franck.lefebure on 16/07/2016.
 */
import com.softbridge.svg.shared.SvgRectangleState;
import com.vaadin.ui.AbstractComponent;

public class SvgRectangle extends SvgShape {

    @Override
    public SvgRectangleState getState() {
        return (SvgRectangleState) super.getState();
    }

    public SvgRectangle(int x, int y, int width, int height) {
        super();
        getState().x = x;
        getState().y = y;
        super.setWidth(width, Unit.PIXELS);
        super.setHeight(height, Unit.PIXELS);
    }

    public void setRoundedCornersRadius(int radius) {
        getState().roundedCornersRadius = radius;
    }
}