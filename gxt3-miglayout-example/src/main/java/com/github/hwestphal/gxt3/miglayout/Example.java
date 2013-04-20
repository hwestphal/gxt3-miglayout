package com.github.hwestphal.gxt3.miglayout;

import net.miginfocom.layout.gxt3.MigLayoutContainer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class Example implements EntryPoint {

	@Override
	public void onModuleLoad() {
		MigLayoutContainer container = new MigLayoutContainer();
		container.setPixelSize(600, 300);

		container.add(new Label("First Name"));
		container.add(new TextField());
		container.add(new Label("Surname"), "gap unrelated");
		container.add(new TextField(), "wrap");
		container.add(new Label("Address"));
		container.add(new TextField(), "span, grow");

		RootPanel.get().add(container);
	}

}
