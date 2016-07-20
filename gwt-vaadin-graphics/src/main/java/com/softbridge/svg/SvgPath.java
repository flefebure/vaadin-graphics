package com.softbridge.svg;

import com.softbridge.svg.shared.SvgPathState;
import com.softbridge.svg.shared.SvgPathStep;

/**
 * Created by franck.lefebure on 18/07/2016.
 */
public class SvgPath extends SvgShape {

    @Override
    public SvgPathState getState() {
        return (SvgPathState) super.getState();
    }

    public SvgPath(int x, int y) {
        moveTo(x, y);
    }

    /**
     * Sets PathStep at the specified position.
     *
     * @param index
     *            the index of the PathStep element to set
     * @param step
     *            PathStep to be stored at the specified position
     * @throws IllegalArgumentException
     */
    public void setStep(int index, SvgPathStep step)
            throws IllegalArgumentException {
        if (index == 0
                && !(step.getSvgPathStepType() == SvgPathStep.SvgPathStepType.MOVE_TO && !step.isRelativeCoords()) ) {
            throw new IllegalArgumentException(
                    "The first step must be an absolute MoveTo step.");
        } else {
            getState().steps.set(index, step);
        }
    }

    /**
     * Removes the PathStep element at the specified position. Shifts any
     * subsequent elements to the left.
     *
     * @param index
     *            the index of the PathStep element to removed
     */
    public void removeStep(int index) {
        getState().steps.remove(index);
    }

    /**
     * Returns the number of PathSteps in this Path.
     *
     * @return the number of PathSteps in this Path.
     */
    public int getStepCount() {
        return getState().steps.size();
    }

    /**
     * Returns the PathStep element at the specified position.
     *
     * @param index
     *            index of element to return.
     * @return the PathStep element at the specified position.
     */
    public SvgPathStep getStep(int index) {
        return getState().steps.get(index);
    }

    /**
     * Start a new sub-path at the given absolute point.
     *
     * @param x
     *            an absolute x-coordinate in pixels
     * @param y
     *            an absolute y-coordinate in pixels
     */
    public void moveTo(int x, int y) {
        SvgPathStep svgPathStep = new SvgPathStep();
        svgPathStep.setSvgPathStepType(SvgPathStep.SvgPathStepType.MOVE_TO);
        svgPathStep.setRelativeCoords(false);
        svgPathStep.setX(x);
        svgPathStep.setY(y);
        getState().steps.add(svgPathStep);
    }

    /**
     * Start a new sub-path at the given relative point.
     *
     * @param x
     *            a relative x-coordinate in pixels
     * @param y
     *            a relative y-coordinate in pixels
     */
    public void moveRelativelyTo(int x, int y) {
        SvgPathStep svgPathStep = new SvgPathStep();
        svgPathStep.setSvgPathStepType(SvgPathStep.SvgPathStepType.MOVE_TO);
        svgPathStep.setRelativeCoords(true);
        svgPathStep.setX(x);
        svgPathStep.setY(y);
        getState().steps.add(svgPathStep);
    }

    /**
     * Draw a line from the current point to the given absolute point.
     *
     * @param x
     *            an absolute x-coordinate in pixels
     * @param y
     *            an absolute y-coordinate in pixels
     */
    public void lineTo(int x, int y) {
        SvgPathStep svgPathStep = new SvgPathStep();
        svgPathStep.setSvgPathStepType(SvgPathStep.SvgPathStepType.LINE_TO);
        svgPathStep.setRelativeCoords(false);
        svgPathStep.setX(x);
        svgPathStep.setY(y);
        getState().steps.add(svgPathStep);
    }

    /**
     * Draw a line from the current point to the given relative point.
     *
     * @param x
     *            a relative x-coordinate in pixels
     * @param y
     *            a relative y-coordinate in pixels
     */
    public void lineRelativelyTo(int x, int y) {
        SvgPathStep svgPathStep = new SvgPathStep();
        svgPathStep.setSvgPathStepType(SvgPathStep.SvgPathStepType.LINE_TO);
        svgPathStep.setRelativeCoords(true);
        svgPathStep.setX(x);
        svgPathStep.setY(y);
        getState().steps.add(svgPathStep);
    }

    /**
     * Draws a cubic B�zier curve.
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x
     * @param y
     */
    public void curveTo(int x1, int y1, int x2, int y2, int x, int y) {
        SvgPathStep svgPathStep = new SvgPathStep();
        svgPathStep.setSvgPathStepType(SvgPathStep.SvgPathStepType.CURVE_TO);
        svgPathStep.setRelativeCoords(false);
        svgPathStep.setX(x);
        svgPathStep.setY(y);
        svgPathStep.setX2(x2);
        svgPathStep.setY2(y2);
        svgPathStep.setX1(x1);
        svgPathStep.setY1(y1);
        getState().steps.add(svgPathStep);
    }

    /**
     * Draws a cubic B�zier curve.
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x
     * @param y
     */
    public void curveRelativelyTo(int x1, int y1, int x2, int y2, int x, int y) {
        SvgPathStep svgPathStep = new SvgPathStep();
        svgPathStep.setSvgPathStepType(SvgPathStep.SvgPathStepType.CURVE_TO);
        svgPathStep.setRelativeCoords(true);
        svgPathStep.setX(x);
        svgPathStep.setY(y);
        svgPathStep.setX2(x2);
        svgPathStep.setY2(y2);
        svgPathStep.setX1(x1);
        svgPathStep.setY1(y1);
        getState().steps.add(svgPathStep);
    }

    public void arc(int rx, int ry, int xAxisRotation, boolean largeArc,
                    boolean sweep, int x, int y) {
        SvgPathStep svgPathStep = new SvgPathStep();
        svgPathStep.setSvgPathStepType(SvgPathStep.SvgPathStepType.ARC);
        svgPathStep.setRelativeCoords(false);
        svgPathStep.setX(x);
        svgPathStep.setY(y);
        svgPathStep.setRx(rx);
        svgPathStep.setRy(ry);
        svgPathStep.setxAxisRotation(xAxisRotation);
        svgPathStep.setLargeArc(largeArc);
        svgPathStep.setSweep(sweep);
        getState().steps.add(svgPathStep);
    }

    public void arcRelatively(int rx, int ry, int xAxisRotation,
                              boolean largeArc, boolean sweep, int x, int y) {
        SvgPathStep svgPathStep = new SvgPathStep();
        svgPathStep.setSvgPathStepType(SvgPathStep.SvgPathStepType.ARC);
        svgPathStep.setRelativeCoords(true);
        svgPathStep.setX(x);
        svgPathStep.setY(y);
        svgPathStep.setRx(rx);
        svgPathStep.setRy(ry);
        svgPathStep.setxAxisRotation(xAxisRotation);
        svgPathStep.setLargeArc(largeArc);
        svgPathStep.setSweep(sweep);
        getState().steps.add(svgPathStep);
    }

    /**
     * Close the path.
     */
    public void close() {
        SvgPathStep svgPathStep = new SvgPathStep();
        svgPathStep.setSvgPathStepType(SvgPathStep.SvgPathStepType.CLOSE);
        getState().steps.add(svgPathStep);
    }


}
