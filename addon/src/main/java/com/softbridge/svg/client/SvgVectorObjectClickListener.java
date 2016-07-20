package com.softbridge.svg.client;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

/**
 * Created by franck.lefebure on 18/07/2016.
 */
public interface SvgVectorObjectClickListener extends ServerRpc {

    public void clicked(MouseEventDetails mouseDetails);

}