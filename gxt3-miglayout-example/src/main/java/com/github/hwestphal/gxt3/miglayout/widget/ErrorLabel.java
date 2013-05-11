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
package com.github.hwestphal.gxt3.miglayout.widget;

import java.util.List;

import net.miginfocom.layout.gxt3.MigLayoutContainer;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.error.ErrorHandler;
import com.sencha.gxt.widget.core.client.form.error.SideErrorHandler.SideErrorResources;

public class ErrorLabel implements IsWidget, ErrorHandler {

	private static final SideErrorResources RESOURCES = GWT.create(SideErrorResources.class);

	private final Widget image;
	private final Label label;
	private final MigLayoutContainer container;

	public ErrorLabel() {
		image = new Image(RESOURCES.errorIcon());
		image.setVisible(false);
		label = new Label("M", false);
		label.setVisible(false);
		container = new MigLayoutContainer("", "0[][grow]0", "0[grow]0");
		container.add(image, "hmin pref, wmin pref");
		container.add(label);
	}

	@Override
	public Widget asWidget() {
		return container;
	}

	@Override
	public void clearInvalid() {
		image.setVisible(false);
		label.setText("");
		label.setVisible(false);
	}

	@Override
	public void markInvalid(List<EditorError> errors) {
		image.setVisible(true);
		label.setText(errors.get(0).getMessage());
		label.setVisible(true);
	}

}
