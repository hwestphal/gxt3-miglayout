package com.github.hwestphal.gxt3.miglayout.example01;

import com.github.hwestphal.gxt3.miglayout.ExampleItem;
import com.github.hwestphal.gxt3.miglayout.ExampleTab;

public class Example01_Quickstart extends ExampleItem {

	public Example01_Quickstart() {
		super(
				"Quick Start",
				"This is an example of how to build a common dialog type. Note that there are no special components, nested panels or absolute references to cell positions. If you look at the source code you will see that the layout code is very simple to understand.",
				new ExampleTab("Quick Start", new Example01_Quickstart_Content()));
	}

}
