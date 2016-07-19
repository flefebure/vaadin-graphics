package com.softbridge.svg;

/**
 * Created by franck.lefebure on 16/07/2016.
 */
import com.softbridge.svg.shared.SvgEllipseState;

public class SvgEllipse extends SvgShape {

    @Override
    public SvgEllipseState getState() {
        return (SvgEllipseState) super.getState();
    }

    public SvgEllipse(int x, int y, int radiusX, int radiusY) {
        super();
        getState().x = x;
        getState().y = y;
        getState().radiusX = radiusX;
        getState().radiusY = radiusY;
    }

    public int getRadiusX() {return getState().radiusX; }
    public int getRadiusY() {return getState().radiusY; }
    public void setRadiusX(int radiusX) {
        getState().radiusX = radiusX;
    }
    public void setRadiusY(int radiusY) {
        getState().radiusY = radiusY;
    }
}