package com.github.hwestphal.gxt3.miglayout;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class ExampleTab implements IsWidget {

	private final String title;
	private final Widget widget;
	private final String sourcePath;

	public ExampleTab(String title, IsWidget widget) {
		this.title = title;
		this.widget = widget.asWidget();
		this.sourcePath = widget.getClass().getName().replace('.', '/') + ".java";
	}

	public String getTitle() {
		return title;
	}

	public String getSourcePath() {
		return sourcePath;
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

}
