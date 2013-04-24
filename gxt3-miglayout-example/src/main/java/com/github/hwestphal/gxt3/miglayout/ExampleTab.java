package com.github.hwestphal.gxt3.miglayout;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class ExampleTab implements IsWidget {

	private final String title;
	private final Widget widget;

	public ExampleTab(String title, IsWidget widget) {
		super();
		this.title = title;
		this.widget = widget.asWidget();
	}

	public String getTitle() {
		return title;
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

}
