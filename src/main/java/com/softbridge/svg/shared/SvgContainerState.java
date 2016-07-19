package com.softbridge.svg.shared;

import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.Connector;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by franck.lefebure on 17/07/2016.
 */
public class SvgContainerState extends AbstractComponentState {
    public List<Connector> vectorObjects = new LinkedList<>();
}
