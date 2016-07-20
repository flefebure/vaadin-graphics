package com.softbridge.svg.client;

import com.vaadin.shared.communication.ClientRpc;
import com.vaadin.shared.communication.ServerRpc;

/**
 * Created by flefebure on 19/07/2016.
 */
public interface SvgVectorObjectBringToFrontListener extends ClientRpc {

    public void bringToFront();
}
