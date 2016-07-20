/*
 * Copyright 2011 Henri Kerola
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.softbridge.svg.shared;

import org.vaadin.gwtgraphics.client.shape.path.*;

import java.io.Serializable;

/**
 * This class is an abstract class for Path steps.
 * 
 * @author Henri Kerola
 * 
 */
public class SvgPathStep implements Serializable {

	public enum SvgPathStepType {
		ARC,
		CLOSE,
		CURVE_TO,
		LINE_TO,
		MOVE_TO
	}

	public String getSVGString(){
		if (svgPathStepType == SvgPathStepType.ARC )
			return isRelativeCoords() ? "a" : "A" + getRx() + "," + getRy() + " "
					+ getxAxisRotation() + " " + (isLargeArc() ? "1" : "0") + ","
					+ (isSweep() ? "1" : "0") + " " + getX() + "," + getY();
		else if (svgPathStepType == SvgPathStepType.MOVE_TO )
			return isRelativeCoords() ? "m" : "M" + getX() + " " + getY();
		else if (svgPathStepType == SvgPathStepType.LINE_TO )
			return isRelativeCoords() ? "l" : "L" + getX() + " " + getY();
		else if (svgPathStepType == SvgPathStepType.CURVE_TO )
			return isRelativeCoords() ? "c" : "C" + getX1() + " " + getY1() + " "
					+ getX2() + " " + getY2() + " " + getX() + " " + getY();
		else if (svgPathStepType == SvgPathStepType.CLOSE )
			return "z";
		return "";

	}

	@Override
	public String toString() {
		return getSVGString();
	}

	private SvgPathStepType svgPathStepType;
	private boolean relativeCoords;
	private int x;
	private int y;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int rx;
	private int ry;
	private int xAxisRotation;
	private boolean largeArc;
	private boolean sweep;


	public boolean isLargeArc() {
		return largeArc;
	}

	public boolean isRelativeCoords() {
		return relativeCoords;
	}

	public int getRx() {
		return rx;
	}

	public int getRy() {
		return ry;
	}

	public SvgPathStepType getSvgPathStepType() {
		return svgPathStepType;
	}

	public boolean isSweep() {
		return sweep;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getX() {
		return x;
	}

	public int getxAxisRotation() {
		return xAxisRotation;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public int getY() {
		return y;
	}

	public void setLargeArc(boolean largeArc) {
		this.largeArc = largeArc;
	}

	public void setRelativeCoords(boolean relativeCoords) {
		this.relativeCoords = relativeCoords;
	}

	public void setRx(int rx) {
		this.rx = rx;
	}

	public void setRy(int ry) {
		this.ry = ry;
	}

	public void setSvgPathStepType(SvgPathStepType svgPathStepType) {
		this.svgPathStepType = svgPathStepType;
	}

	public void setSweep(boolean sweep) {
		this.sweep = sweep;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setxAxisRotation(int xAxisRotation) {
		this.xAxisRotation = xAxisRotation;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public void setY(int y) {
		this.y = y;
	}
}
