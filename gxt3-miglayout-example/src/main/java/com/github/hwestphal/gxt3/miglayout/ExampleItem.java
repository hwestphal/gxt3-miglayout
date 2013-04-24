package com.github.hwestphal.gxt3.miglayout;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExampleItem {

	private final String title;
	private final String description;
	private final List<ExampleTab> exampleTabs;

	public ExampleItem(String title, String description, ExampleTab... exampleTabs) {
		this.title = title;
		this.description = description;
		this.exampleTabs = Collections.unmodifiableList(Arrays.asList(exampleTabs));
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public List<ExampleTab> getExampleTabs() {
		return exampleTabs;
	}

}
