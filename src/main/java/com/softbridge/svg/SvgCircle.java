package com.softbridge.svg;

/**
 * Created by franck.lefebure on 16/07/2016.
 */
import com.softbridge.svg.shared.SvgCircleState;

public class SvgCircle extends SvgShape {

    @Override
    public SvgCircleState getState() {
        return (SvgCircleState) super.getState();
    }

    public SvgCircle(int x, int y, int radius) {
        super();
        getState().x = x;
        getState().y = y;
        getState().radius = radius;
    }
    public int getRadius() {return getState().radius; }
    public void setRadius(int radius) {
        getState().radius = radius;
    }
}