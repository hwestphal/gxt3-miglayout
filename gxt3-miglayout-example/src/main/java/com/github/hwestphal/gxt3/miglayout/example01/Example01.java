package com.github.hwestphal.gxt3.miglayout.example01;

import com.github.hwestphal.gxt3.miglayout.ExampleItem;
import com.github.hwestphal.gxt3.miglayout.ExampleTab;

public class Example01 extends ExampleItem {

	public Example01() {
		super(
				"Quick Start",
				"To give you an idea about how the layout manager works, below is the source code for the Quick Start panel. Note that all gaps (white space) is added automatically. The gaps will be correct for the platform it is run. Even the white space around the components (border) is automatic!",
				new ExampleTab("Quick Start", new Example01Content()));
	}

}
