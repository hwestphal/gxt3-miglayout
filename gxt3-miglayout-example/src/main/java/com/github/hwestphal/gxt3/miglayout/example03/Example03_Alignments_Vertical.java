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
package com.github.hwestphal.gxt3.miglayout.example03;

import java.util.Arrays;
import java.util.List;

import net.miginfocom.layout.gxt3.MigLayoutContainer;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.form.TextArea;

public class Example03_Alignments_Vertical implements IsWidget {

	private MigLayoutContainer container;

	@Override
	public Widget asWidget() {
		if (container == null) {
			container = new MigLayoutContainer("wrap,flowy", "[]unrel[]rel[]", "[top]15[center]15[bottom]15[fill]15[fill,baseline]15[baseline]15[]");

			List<String> verLabels = Arrays.asList("[top]", "[center]", "[bottom]", "[fill]", "[fill,baseline]", "[baseline]", "[] (Default)");
			for (String verLabel : verLabels) {
				container.add(new Label(verLabel));
			}

			List<String> verNames = Arrays.asList("One", "One<br />Two");
			for (String verName : verNames) {
				for (int i = 0; i < verLabels.size(); i++) {
					TextButton button = new TextButton();
					button.setHTML(verName);
					container.add(button);
				}
			}

			for (int i = 0; i < verLabels.size(); i++) {
				TextArea textArea = new TextArea();
				textArea.setText("Text Area\nwith two lines");
				textArea.setPreventScrollbars(true);
				container.add(textArea);
			}

			for (int i = 0; i < verLabels.size(); i++) {
				TextArea textArea = new TextArea();
				textArea.setText("Text Area\nwith three lines\nand scrolling");
				textArea.getElement().getStyle().setOverflow(Overflow.AUTO);
				container.add(textArea);
			}
		}
		return container;
	}

}
