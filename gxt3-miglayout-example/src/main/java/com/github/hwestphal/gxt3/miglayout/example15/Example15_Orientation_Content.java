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
package com.github.hwestphal.gxt3.miglayout.example15;

import net.miginfocom.layout.gxt3.MigLayoutContainer;

import com.github.hwestphal.gxt3.miglayout.widget.Separator;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.TextField;

public class Example15_Orientation_Content implements IsWidget {

	private MigLayoutContainer container;

	@Override
	public Widget asWidget() {
		if (container == null) {
			container = new MigLayoutContainer("flowy", "[grow,fill]", "[grow,fill]20[grow,fill]20[grow,fill]20[grow,fill]");

			MigLayoutContainer defLM = new MigLayoutContainer("", "[trailing][grow,fill]", "");
			addSeparator(defLM, "Default Orientation");
			addFields(defLM);

			MigLayoutContainer rtlLM = new MigLayoutContainer("rtl,ttb", "[trailing][grow,fill]", "");
			addSeparator(rtlLM, "Right to Left");
			addFields(rtlLM);

			MigLayoutContainer rtlbLM = new MigLayoutContainer("rtl,btt", "[trailing][grow,fill]", "");
			addSeparator(rtlbLM, "Right to Left, Bottom to Top");
			addFields(rtlbLM);

			MigLayoutContainer ltrbLM = new MigLayoutContainer("ltr,btt", "[trailing][grow,fill]", "");
			addSeparator(ltrbLM, "Left to Right, Bottom to Top");
			addFields(ltrbLM);

			container.add(defLM);
			container.add(rtlLM);
			container.add(rtlbLM);
			container.add(ltrbLM);
		}
		return container;
	}

	private void addSeparator(MigLayoutContainer container, String text) {
		Label label = new Label(text, false);
		label.getElement().getStyle().setColor("blue");
		container.add(label, "gapbottom 1, span, split 2, aligny center");
		container.add(new Separator(), "gapleft rel, growx");
	}

	private void addFields(MigLayoutContainer container) {
		container.add(new Label("Level of Trust"));
		container.add(new TextField(), "span,growx");
		container.add(new Label("Radar Presentation"));
		container.add(new TextField());
		container.add(new TextField());
	}

}
