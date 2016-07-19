# vaadin-graphics

This is my fist vaadin add-on and a component which wraps the gwt-graphics add-on
Some links about gwt-graphics :

    - https://vaadin.com/directory#!addon/gwt-graphics
    - https://code.google.com/archive/p/gwt-graphics/
    - https://github.com/henrikerola/gwt-graphics

Basic Svg objects can be generated and manipulated with server-side Vaadin code.
```
VerticalLayout layout = new VerticalLayout();
SvgDrawingArea svgDrawingArea = new SvgDrawingArea(1000,500);
SvgRectangle svgRectangle = new SvgRectangle(50, 100, 100, 200);
layout.addComponent(svgDrawingArea);
svgDrawingArea.addVectorObject(svgRectangle);
```

Have a look at SvgTestUI.class
