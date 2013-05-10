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
package com.github.hwestphal.gxt3.miglayout.example22;

import java.util.Arrays;

import net.miginfocom.layout.gxt3.MigLayoutContainer;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.widget.core.client.ListView;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.form.ListField;
import com.sencha.gxt.widget.core.client.form.TextField;

public class Example22_LayoutShowdown_Improved implements IsWidget {

	private MigLayoutContainer container;

	@Override
	public Widget asWidget() {
		if (container == null) {
			container = new MigLayoutContainer("", "[]15[][grow,fill]15[][grow,fill]");

			container.add(createListField("Mouse, Mickey", "Duck, Donald"), "spany, growy, wmin 150");

			container.add(new Label("Last Name"));
			container.add(new TextField());
			container.add(new Label("First Name"));
			container.add(new TextField(), "wrap");
			container.add(new Label("Phone"));
			container.add(new TextField());
			container.add(new Label("Email"));
			container.add(new TextField(), "wrap");
			container.add(new Label("Address 1"));
			container.add(new TextField(), "span");
			container.add(new Label("Address 2"));
			container.add(new TextField(), "span");
			container.add(new Label("City"));
			container.add(new TextField(), "wrap");
			container.add(new Label("State"));
			container.add(new TextField());
			container.add(new Label("Postal Code"));
			container.add(new TextField(), "growx 0, wrap");
			container.add(new Label("Country"));
			container.add(new TextField(), "wrap 15");

			container.add(new TextButton("New"), "tag other, span, split");
			container.add(new TextButton("Delete"), "tag other");
			container.add(new TextButton("Edit"), "tag other");
			container.add(new TextButton("Save"), "tag other");
			container.add(new TextButton("Cancel"), "tag cancel, wrap push");
		}
		return container;
	}

	private Widget createListField(String... item) {
		ListStore<String> listStore = new ListStore<String>(new ModelKeyProvider<String>() {
			@Override
			public String getKey(String item) {
				return item;
			}
		});
		listStore.addAll(Arrays.asList(item));
		return new ListField<String, String>(new ListView<String, String>(listStore, new IdentityValueProvider<String>()));
	}

}
