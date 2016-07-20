package com.softbridge.svg;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.shared.SvgLineState;

public class SvgLine extends SvgVectorObject {

    @Override
    public SvgLineState getState() {
        return (SvgLineState) super.getState();
    }

    public SvgLine(int x1, int y1, int x2, int y2) {
        super();
        getState().x1 = x1;
        getState().y1 = y1;
        getState().x2 = x2;
        getState().y2 = y2;
    }
    public int getX1() {return getState().x1;}
    public int getY1() {return getState().y1;}
    public int getX2() {return getState().x2;}
    public int getY2() {return getState().y2;}
    public void setX1(int x1) {
        getState().x1 = x1;
    }
    public void setY1(int y1) {
        getState().y1 = y1;
    }
    public void setX2(int x2) {
        getState().x2 = x2;
    }
    public void setY2(int y2) {
        getState().y2 = y2;
    }
}