package com.github.hwestphal.gxt3.miglayout.example02;

import com.github.hwestphal.gxt3.miglayout.ExampleItem;
import com.github.hwestphal.gxt3.miglayout.ExampleTab;

public class Example02_Plain extends ExampleItem {

	public Example02_Plain() {
		super("Plain", "A simple example on how simple it is to create normal forms. No builders needed since the whole layout manager works like a builder.",
				new ExampleTab("Plain", new Example02_Plain_Content()));
	}

}
