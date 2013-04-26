package com.github.hwestphal.gxt3.miglayout;

import com.github.hwestphal.gxt3.miglayout.example01.Example01_Quickstart;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Example implements EntryPoint {

	@Override
	public void onModuleLoad() {
		ExampleBrowser exampleBrowser = new ExampleBrowser();
		exampleBrowser.addExample(new Example01_Quickstart());
		RootLayoutPanel.get().add(exampleBrowser);
	}

}
