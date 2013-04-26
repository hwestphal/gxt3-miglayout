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
