package com.softbridge.svg.client;

/**
 * Created by franck.lefebure on 16/07/2016.
 */

import com.softbridge.svg.SvgPath;
import com.softbridge.svg.shared.SvgPathState;
import com.softbridge.svg.shared.SvgPathStep;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.shared.ui.Connect;
import org.vaadin.gwtgraphics.client.shape.Path;
import org.vaadin.gwtgraphics.client.shape.path.MoveTo;
import org.vaadin.gwtgraphics.client.shape.path.PathStep;

@Connect(SvgPath.class)
public class SvgPathConnector extends SvgShapeConnector {
    @Override
    protected Path createWidget() {
        return new Path(0,0);
    }
    @Override
    public Path getWidget() {
        return (Path) super.getWidget();
    }
    @Override
    public SvgPathState getState() {
        return (SvgPathState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {

        super.onStateChanged(stateChangeEvent);
        for (int i = 0; i < getWidget().getStepCount(); i++) {
            getWidget().removeStep(0);
        }
        for (int i = 0; i < getState().steps.size(); i++) {
            SvgPathStep svgStep =  getState().steps.get(i);
            if (svgStep.getSvgPathStepType() == SvgPathStep.SvgPathStepType.MOVE_TO && !svgStep.isRelativeCoords())
                getWidget().moveTo(svgStep.getX(), svgStep.getY());
            else if (svgStep.getSvgPathStepType() == SvgPathStep.SvgPathStepType.MOVE_TO && svgStep.isRelativeCoords())
                getWidget().moveRelativelyTo(svgStep.getX(), svgStep.getY());
            else if (svgStep.getSvgPathStepType() == SvgPathStep.SvgPathStepType.LINE_TO && !svgStep.isRelativeCoords())
                getWidget().lineTo(svgStep.getX(), svgStep.getY());
            else if (svgStep.getSvgPathStepType() == SvgPathStep.SvgPathStepType.LINE_TO && svgStep.isRelativeCoords())
                getWidget().lineRelativelyTo(svgStep.getX(), svgStep.getY());
            else if (svgStep.getSvgPathStepType() == SvgPathStep.SvgPathStepType.CURVE_TO && !svgStep.isRelativeCoords())
                getWidget().curveTo(svgStep.getX1(), svgStep.getY1(), svgStep.getX2(), svgStep.getY2(), svgStep.getX(), svgStep.getY());
            else if (svgStep.getSvgPathStepType() == SvgPathStep.SvgPathStepType.CURVE_TO && svgStep.isRelativeCoords())
                getWidget().curveRelativelyTo(svgStep.getX1(), svgStep.getY1(), svgStep.getX2(), svgStep.getY2(), svgStep.getX(), svgStep.getY());
            else if (svgStep.getSvgPathStepType() == SvgPathStep.SvgPathStepType.ARC && !svgStep.isRelativeCoords())
                getWidget().arc(svgStep.getRx(), svgStep.getRy(), svgStep.getxAxisRotation(), svgStep.isLargeArc(), svgStep.isSweep(), svgStep.getX(), svgStep.getY());
            else if (svgStep.getSvgPathStepType() == SvgPathStep.SvgPathStepType.ARC && svgStep.isRelativeCoords())
                getWidget().arcRelatively(svgStep.getRx(), svgStep.getRy(), svgStep.getxAxisRotation(), svgStep.isLargeArc(), svgStep.isSweep(), svgStep.getX(), svgStep.getY());
            else if (svgStep.getSvgPathStepType() == SvgPathStep.SvgPathStepType.CLOSE) {
                getWidget().close();
            }
        }
    }
    @Override
    protected void updateComponentSize(String newWidth, String newHeight) {
    }
}
