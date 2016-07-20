package com.softbridge.svg;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.shared.SvgContainerState;
import com.vaadin.shared.Connector;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class SvgContainer extends SvgObject implements HasComponents {

    @Override
    public SvgContainerState getState() {
        return (SvgContainerState) super.getState();
    }

    @Override
    public SvgContainerState getState(boolean markAsDirty) {
        return (SvgContainerState) super.getState(markAsDirty);
    }

    public SvgContainer() {
    }

    public SvgContainer(int width, int height) {
        super.setWidth(width, Unit.PIXELS);
        super.setHeight(height, Unit.PIXELS);
    }


    public void addVectorObject(SvgObject svgObject) {
        getState().vectorObjects.add(svgObject);
        svgObject.setParent(this);
    }

    public void setVectorObject(int index, SvgObject svgObject) {
        SvgObject oldSvgObject = (SvgObject)getState().vectorObjects.get(index);
        oldSvgObject.setParent(null);
        getState().vectorObjects.set(index, svgObject);
        svgObject.setParent(this);
    }

    public void removeVectorObject(SvgObject svgObject) {
        svgObject.setParent(null);
        getState().vectorObjects.remove(svgObject);
    }

    public void removeVectorObject(int index) {
        SvgObject svgObject = (SvgObject)getState().vectorObjects.get(index);
        svgObject.setParent(null);
        getState().vectorObjects.remove(index);
    }

    public SvgObject getVectorObject(int index) {
        return (SvgObject)getState().vectorObjects.get(index);
    }

    public int getSvgObjectIndex(SvgObject svgObjectt) {
        return getState().vectorObjects.indexOf(svgObjectt);
    }

    @Override
    public Iterator<Component> iterator() {
        List<Component> l = new ArrayList<Component>();
        for (Connector c : getState(false).vectorObjects) {
            l.add((Component) c);
        }
        return l.iterator();
    }
}