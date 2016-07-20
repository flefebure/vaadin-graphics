package com.softbridge.svg.client;

import com.vaadin.shared.AbstractComponentState;

/**
 * Created by franck.lefebure on 18/07/2016.
 */
public class SvgConnectorUtils {
    public static String correctSize(String size) {
        // need to transfor eg 400.0px -> 400px
        int correctedSize = 0;
        try {
            String s = size.substring(0, size.length()-4);
            correctedSize = Integer.parseInt(s);
        } catch (NumberFormatException e) {
        }

        return correctedSize+"px";
    }
}
