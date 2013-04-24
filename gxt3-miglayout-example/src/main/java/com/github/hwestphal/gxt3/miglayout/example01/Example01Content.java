package com.github.hwestphal.gxt3.miglayout.example01;

import net.miginfocom.layout.gxt3.MigLayoutContainer;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.TextField;

public class Example01Content implements IsWidget {

	private final MigLayoutContainer container;

	public Example01Content() {
		container = new MigLayoutContainer();
		container.add(new Label("First Name", false));
		container.add(new TextField());
		container.add(new Label("Surname"), "gap unrelated");
		container.add(new TextField(), "wrap");
		container.add(new Label("Address"));
		container.add(new TextField(), "span, grow");
	}

	@Override
	public Widget asWidget() {
		return container;
	}

}
