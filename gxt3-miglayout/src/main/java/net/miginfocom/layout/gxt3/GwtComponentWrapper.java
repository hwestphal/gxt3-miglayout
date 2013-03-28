/*
 * Copyright (c) 2013, Harald Westphal
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of the author nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
 * DAMAGE.
 */
package net.miginfocom.layout.gxt3;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.ContainerWrapper;

import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.Widget;

class GwtComponentWrapper implements ComponentWrapper {

	private final Widget widget;

	public GwtComponentWrapper(Widget component) {
		widget = component;
	}

	@Override
	public Object getComponent() {
		return widget;
	}

	@Override
	public int getX() {
		return widget.getAbsoluteLeft();
	}

	@Override
	public int getY() {
		return widget.getAbsoluteTop();
	}

	@Override
	public int getWidth() {
		return widget.getOffsetWidth();
	}

	@Override
	public int getHeight() {
		return widget.getOffsetHeight();
	}

	@Override
	public int getScreenLocationX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScreenLocationY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinimumWidth(int hHint) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinimumHeight(int wHint) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreferredWidth(int hHint) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreferredHeight(int wHint) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaximumWidth(int hHint) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaximumHeight(int wHint) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isVisible() {
		return widget.isVisible();
	}

	@Override
	public int getBaseline(int width, int height) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasBaseline() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContainerWrapper getParent() {
		Widget parent = widget.getParent();
		if (parent instanceof IndexedPanel) {
			return new GwtContainerWrapper((IndexedPanel) parent);
		}
		return null;
	}

	@Override
	public float getPixelUnitFactor(boolean isHor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHorizontalScreenDPI() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVerticalScreenDPI() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScreenWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScreenHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLinkId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLayoutHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getVisualPadding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void paintDebugOutline() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getComponetType(boolean disregardScrollPane) {
		return TYPE_UNKNOWN;
	}

}
