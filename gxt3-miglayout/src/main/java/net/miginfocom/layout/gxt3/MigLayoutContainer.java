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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.ConstraintParser;
import net.miginfocom.layout.Grid;
import net.miginfocom.layout.LC;
import net.miginfocom.layout.LayoutCallback;

import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.container.InsertResizeContainer;

public class MigLayoutContainer extends InsertResizeContainer {

	private final ArrayList<LayoutCallback> layoutCallbacks = new ArrayList<LayoutCallback>();
	private final Map<ComponentWrapper, CC> ccMap = new HashMap<ComponentWrapper, CC>();
	private final LC layoutConstraints;
	private final AC colConstraints;
	private final AC rowConstraints;

	public MigLayoutContainer() {
		this("");
	}

	public MigLayoutContainer(LC layoutConstraints) {
		this(layoutConstraints, null);
	}

	public MigLayoutContainer(LC layoutConstraints, AC colConstraints) {
		this(layoutConstraints, colConstraints, null);
	}

	public MigLayoutContainer(String layoutConstraints) {
		this(layoutConstraints, null);
	}

	public MigLayoutContainer(String layoutConstraints, String colConstraints) {
		this(layoutConstraints, colConstraints, null);
	}

	public MigLayoutContainer(String layoutConstraints, String colConstraints, String rowConstraints) {
		this(ConstraintParser.parseLayoutConstraint(ConstraintParser.prepare(layoutConstraints)), ConstraintParser.parseColumnConstraints(ConstraintParser
				.prepare(colConstraints)), ConstraintParser.parseRowConstraints(ConstraintParser.prepare(rowConstraints)));
	}

	public MigLayoutContainer(LC layoutConstraints, AC colConstraints, AC rowConstraints) {
		this.layoutConstraints = layoutConstraints;
		this.colConstraints = colConstraints;
		this.rowConstraints = rowConstraints;
		setElement(DOM.createDiv());
		getContainerTarget().makePositionable();
	}

	public void addLayoutCallback(LayoutCallback callback) {
		if (!layoutCallbacks.contains(callback)) {
			layoutCallbacks.add(callback);
		}
	}

	public void removeLayoutCallback(LayoutCallback callback) {
		layoutCallbacks.remove(callback);
	}

	@Override
	public void insert(Widget child, int beforeIndex) {
		if (child instanceof Component) {
			Component component = (Component) child;
			CC cc = (CC) child.getLayoutData();
			if (cc != null) {
				ccMap.put(new GxtComponentWrapper(component), cc);
			}
			super.insert(child, beforeIndex);
		} else {
			Component component = new GxtWrapper(child);
			component.setLayoutData(child.getLayoutData());
			insert(component, beforeIndex);
		}
	}

	@Override
	public boolean remove(Widget child) {
		ccMap.remove(new GxtComponentWrapper((Component) child));
		return super.remove(child);
	}

	@UiChild(tagname = "child")
	public void add(IsWidget child, String layoutData) {
		child.asWidget().setLayoutData(ConstraintParser.parseComponentConstraint(layoutData));
		add(child);
	}

	public void insert(IsWidget child, int beforeIndex, String layoutData) {
		child.asWidget().setLayoutData(ConstraintParser.parseComponentConstraint(layoutData));
		insert(child, beforeIndex);
	}

	@Override
	protected void doLayout() {
		new Grid(new GxtContainerWrapper(this), layoutConstraints, rowConstraints, colConstraints, ccMap, layoutCallbacks).layout(new int[] { 0, 0,
				getOffsetWidth(true), getOffsetHeight(true) }, null, null, false, false);
	}

}
