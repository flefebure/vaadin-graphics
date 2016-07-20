package com.softbridge.svg;

/**
 * Created by franck.lefebure on 16/07/2016.
 */
import com.softbridge.svg.shared.SvgDrawingAreaState;
import com.vaadin.ui.*;

public class SvgDrawingArea extends SvgContainer implements HasComponents {

    @Override
    public SvgDrawingAreaState getState() {
        return (SvgDrawingAreaState) super.getState();
    }

    @Override
    public SvgDrawingAreaState getState(boolean markAsDirty) {
        return (SvgDrawingAreaState) super.getState(markAsDirty);
    }

    public SvgDrawingArea(int width, int height) {
        super(width, height);
    }

}