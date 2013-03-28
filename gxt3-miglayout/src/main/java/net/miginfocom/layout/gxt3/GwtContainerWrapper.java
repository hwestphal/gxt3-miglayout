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

class GwtContainerWrapper extends GwtComponentWrapper implements ContainerWrapper {

	private final IndexedPanel container;

	public GwtContainerWrapper(IndexedPanel container) {
		super((Widget) container);
		this.container = container;
	}

	@Override
	public ComponentWrapper[] getComponents() {
		ComponentWrapper[] components = new ComponentWrapper[getComponentCount()];
		for (int i = 0; i < components.length; i++) {
			components[i] = new GwtComponentWrapper(container.getWidget(i));
		}
		return components;
	}

	@Override
	public int getComponentCount() {
		return container.getWidgetCount();
	}

	@Override
	public Object getLayout() {
		return container;
	}

	@Override
	public boolean isLeftToRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void paintDebugCell(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getComponetType(boolean disregardScrollPane) {
		return TYPE_CONTAINER;
	}

}
