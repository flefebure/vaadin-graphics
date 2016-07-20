package com.softbridge.svg;

import com.softbridge.svg.client.SvgVectorObjectBringToFrontListener;
import com.softbridge.svg.client.SvgVectorObjectClickListener;
import com.softbridge.svg.shared.SvgVectorObjectState;
import org.vaadin.gwtgraphics.client.VectorObject;

/**
 * Created by franck.lefebure on 18/07/2016.
 */
public abstract class SvgVectorObject extends SvgObject {

    private SvgVectorObjectClickListener svgVectorObjectClickListener;

    public SvgVectorObject() {
        this.setStrokeColor("black");
        this.setStrokeOpacity(1.0D);
        this.setStrokeWidth(1);
        setSvgVectorObjectClickListener(mouseDetails -> {});
    }

    @Override
    public SvgVectorObjectState getState() {
        return (SvgVectorObjectState) super.getState();
    }

    public void setRotation(int rotation) {
        getState().rotation = rotation;
    }
    public void setStrokeColor(String strokeColor) {
        getState().strokeColor = strokeColor;
    }
    public void setStrokeWidth(int strokeWidth) {
        getState().strokeWidth = strokeWidth;
    }
    public void setStrokeOpacity(double strokeOpacity) {
        getState().strokeOpacity = strokeOpacity;
    }

    public int getRotation() {
        return getState().rotation;
    }
    public String getStrokeColor() {
        return getState().strokeColor;
    }
    public int getStrokeWidth() {
        return  getState().strokeWidth;
    }
    public double getStrokeOpacity(){ return getState().strokeOpacity;}

    public SvgVectorObjectClickListener getSvgVectorObjectClickListener() {
        return svgVectorObjectClickListener;
    }

    public void setSvgVectorObjectClickListener(SvgVectorObjectClickListener svgVectorObjectClickListener) {
        this.svgVectorObjectClickListener = svgVectorObjectClickListener;
        registerRpc(svgVectorObjectClickListener);
    }

    public void bringToFront() {
        getRpcProxy(SvgVectorObjectBringToFrontListener.class).bringToFront();
    }

}
