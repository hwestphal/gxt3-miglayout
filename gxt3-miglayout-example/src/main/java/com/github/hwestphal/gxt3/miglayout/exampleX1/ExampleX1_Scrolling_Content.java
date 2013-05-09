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
package com.github.hwestphal.gxt3.miglayout.exampleX1;

import net.miginfocom.layout.gxt3.MigLayoutContainer;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ExampleX1_Scrolling_Content implements IsWidget {

	private MigLayoutContainer container;

	@Override
	public Widget asWidget() {
		if (container == null) {
			container = new MigLayoutContainer();
			container.add(createDialogButton("Hidden Scrollbar", Overflow.HIDDEN));
			container.add(createDialogButton("Visible Scrollbar", Overflow.SCROLL));
			container.add(createDialogButton("Auto Scrollbar", Overflow.AUTO));
		}
		return container;
	}

	private Widget createDialogButton(String title, Overflow overflowMode) {
		final Dialog dialog = new Dialog();
		dialog.setHeadingText(title);
		dialog.setModal(true);
		dialog.setPredefinedButtons(PredefinedButton.OK, PredefinedButton.CANCEL);
		dialog.setHideOnButtonClick(true);
		dialog.setPixelSize(500, 200);

		final MigLayoutContainer form = createForm(overflowMode);
		dialog.add(form);

		CheckBox checkBox = new CheckBox();
		checkBox.setTitle("Debug");
		dialog.addButton(checkBox);
		checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				form.setDebug(event.getValue());
				form.layout();
			}
		});

		TextButton button = new TextButton(title);
		button.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				dialog.show();
			}
		});

		return button;
	}

	private MigLayoutContainer createForm(Overflow overflowMode) {
		MigLayoutContainer container = new MigLayoutContainer();
		container.add(new Label("First Name", false), "wmin pref, hmin pref");
		container.add(new TextField(), "wmin pref, hmin pref");
		container.add(new Label("Surname"), "gap unrelated, wmin pref, hmin pref");
		container.add(new TextField(), "wrap, wmin pref, hmin pref");
		container.add(new Label("Address"), "wmin pref, hmin pref");
		container.add(new TextField(), "span, grow, wrap, wmin pref, hmin pref");
		container.add(new Label("Phone", false), "wmin pref, hmin pref");
		container.add(new TextField(), "wmin pref, hmin pref");
		container.add(new Label("Email"), "gap unrelated, wmin pref, hmin pref");
		container.add(new TextField(), "wmin pref, hmin pref");
		container.getElement().getStyle().setOverflow(overflowMode);
		return container;
	}

}
