package com.softbridge.svg;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.shared.SvgImageState;

public class SvgImage extends SvgVectorObject {

    @Override
    public SvgImageState getState() {
        return (SvgImageState) super.getState();
    }

    public SvgImage(int x, int y, int width, int height, String href) {
        super();
        getState().x = x;
        getState().y = y;
        getState().href = href;
        super.setWidth(width, Unit.PIXELS);
        super.setHeight(height, Unit.PIXELS);
    }

    public int getX() {return getState().x;}
    public int getY() {return getState().y;}
    public String getHref() {return getState().href;}
    public void setX(int x) {
        getState().x = x;
    }
    public void setY(int y) {
        getState().y = y;
    }
    public void setHref(String href) {
        getState().href = href;
    }
}