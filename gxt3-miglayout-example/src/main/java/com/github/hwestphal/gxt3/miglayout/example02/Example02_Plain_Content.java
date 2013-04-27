package com.github.hwestphal.gxt3.miglayout.example02;

import net.miginfocom.layout.gxt3.MigLayoutContainer;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.TextField;

public class Example02_Plain_Content implements IsWidget {

	private final MigLayoutContainer container;

	public Example02_Plain_Content() {
		container = new MigLayoutContainer("ins 20", "[para]0[][100lp, fill][60lp][95lp, fill]", "");

		addSeparator("Manufacturer");

		container.add(new Label("Company"), "skip");
		container.add(new TextField(), "span, growx");
		container.add(new Label("Contact"), "skip");
		container.add(new TextField(), "span, growx");
		container.add(new Label("Order No"), "skip");
		container.add(new TextField(), "wrap para");

		addSeparator("Inspector");

		container.add(new Label("Name"), "skip");
		container.add(new TextField(), "span, growx");
		container.add(new Label("Reference No"), "skip");
		container.add(new TextField(), "wrap");
		container.add(new Label("Status"), "skip");
		container.add(createCombo("In Progress", "Finnished", "Released"), "wrap para");

		addSeparator("Ship");

		container.add(new Label("Shipyard"), "skip");
		container.add(new TextField(), "span, growx");
		container.add(new Label("Register No"), "skip");
		container.add(new TextField());
		container.add(new Label("Hull No"), "right");
		container.add(new TextField(), "wrap");
		container.add(new Label("Project StructureType"), "skip");
		container.add(createCombo("New Building", "Convention", "Repair"));
	}

	private IsWidget createCombo(String... items) {
		ListBox comboBox = new ListBox();
		for (String item : items) {
			comboBox.addItem(item);
		}
		return comboBox;
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
