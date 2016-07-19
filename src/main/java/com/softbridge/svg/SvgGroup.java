package com.softbridge.svg;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.shared.SvgGroupState;

public class SvgGroup extends SvgContainer {

    @Override
    public SvgGroupState getState() {
        return (SvgGroupState) super.getState();
    }

    @Override
    public SvgGroupState getState(boolean markAsDirty) {
        return (SvgGroupState) super.getState(markAsDirty);
    }

    public SvgGroup() {
    }

}