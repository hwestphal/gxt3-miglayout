/*
 * License (BSD):
 * ==============
 *
 * Copyright (c) 2004, Mikael Grev, MiG InfoCom AB. (miglayout (at) miginfocom (dot) com)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution.
 * Neither the name of the MiG InfoCom AB nor the names of its contributors may be
 * used to endorse or promote products derived from this software without specific
 * prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 *
 * @version 1.0
 * @author Mikael Grev, MiG InfoCom AB
 *         Date: 2006-sep-08
 */
package com.github.hwestphal.gxt3.miglayout.example01;

import net.miginfocom.layout.gxt3.MigLayoutContainer;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.TextField;

public class Example01_Quickstart_Content implements IsWidget {

	private final MigLayoutContainer container;

	public Example01_Quickstart_Content() {
		container = new MigLayoutContainer("inset 20");

		addSeparator("General");

		container.add(new Label("Company"), "gap para, wmin pref");
		container.add(new TextField(), "span, growx");
		container.add(new Label("Contact"), "gap para, wmin pref");
		container.add(new TextField(), "span, growx, wrap para");

		addSeparator("Propeller");

		container.add(new Label("PTI/kW"), "gap para, wmin pref");
		container.add(new TextField());
		container.add(new Label("Power/kW"), "gap para, wmin pref");
		container.add(new TextField(), "wrap");
		container.add(new Label("R/mm"), "gap para, wmin pref");
		container.add(new TextField());
		container.add(new Label("D/mm"), "gap para, wmin pref");
		container.add(new TextField());
	}

	private void addSeparator(String text) {
		Label label = new Label(text, false);
		label.getElement().getStyle().setColor("blue");
		container.add(label, "gapbottom 1, span, split 2, aligny center");
		Widget separator = new Widget() {
			{
				Element div = DOM.createDiv();
				div.appendChild(DOM.createElement("hr"));
				setElement(div);
			}
		};
		container.add(separator, "gapleft rel, growx");
	}

	@Override
	public Widget asWidget() {
		return container;
	}

}
