package com.softbridge.svg;

import com.softbridge.svg.shared.SvgShapeState;

/**
 * Created by franck.lefebure on 18/07/2016.
 */
public class SvgShape  extends SvgVectorObject {

    @Override
    public SvgShapeState getState() {
        return (SvgShapeState) super.getState();
    }

    public SvgShape() {
        super();
        this.setFillColor("white");
        this.setFillOpacity(1.0D);
    }

    public int getX() {return getState().x;}
    public int getY() {return getState().y;}
    public String getFillColor() {return getState().fillColor;}
    public double getFillOpacity() {return getState().fillOpacity;}
    public void setX(int x) {
        getState().x = x;
    }
    public void setY(int y) {
        getState().y = y;
    }
    public void setFillColor(String fillColor) {
        getState().fillColor = fillColor;
    }
    public void setFillOpacity(double fillOpacity) {
        getState().fillOpacity = fillOpacity;
    }

}
