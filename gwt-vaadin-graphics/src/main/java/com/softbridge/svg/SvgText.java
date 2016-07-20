package com.softbridge.svg;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.shared.SvgTextState;

public class SvgText extends SvgShape {

    @Override
    public SvgTextState getState() {
        return (SvgTextState) super.getState();
    }

    public SvgText(int x, int y, String text) {
        super();
        getState().x = x;
        getState().y = y;
        getState().text = text;
        getState().fontFamily = "Arial";
        getState().fontSize = 20;
    }

    public String getText() {return getState().text;}
    public String getFontFamily() {return getState().fontFamily;}
    public int getFontSize() {return getState().fontSize;}
    public void setText(String text) {
        getState().text = text;
    }
    public void setFontFamily(String fontFamily) {
        getState().fontFamily = fontFamily;
    }
    public void setFontSize(int fontSize) {
        getState().fontSize = fontSize;
    }
}