/*
 * Copyright (c) 2013, Harald Westphal
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of the author nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
 * DAMAGE.
 */
package com.github.hwestphal.gxt3.miglayout;

import com.github.hwestphal.gxt3.miglayout.example01.Example01_Quickstart;
import com.github.hwestphal.gxt3.miglayout.example02.Example02_Plain;
import com.github.hwestphal.gxt3.miglayout.example03.Example03_Alignments;
import com.github.hwestphal.gxt3.miglayout.example04.Example04_CellAlignments;
import com.github.hwestphal.gxt3.miglayout.example21.Example21_Debug;
import com.github.hwestphal.gxt3.miglayout.example22.Example22_LayoutShowdown;
import com.github.hwestphal.gxt3.miglayout.example23.Example23_ConstraintsAPI;
import com.github.hwestphal.gxt3.miglayout.exampleX1.ExampleX1_Scrollbars;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Example implements EntryPoint {

	@Override
	public void onModuleLoad() {
		ExampleBrowser exampleBrowser = new ExampleBrowser();
		exampleBrowser.addExample(new Example01_Quickstart());
		exampleBrowser.addExample(new Example02_Plain());
		exampleBrowser.addExample(new Example03_Alignments());
		exampleBrowser.addExample(new Example04_CellAlignments());
		exampleBrowser.addExample(new Example21_Debug());
		exampleBrowser.addExample(new Example22_LayoutShowdown());
		exampleBrowser.addExample(new Example23_ConstraintsAPI());
		exampleBrowser.addExample(new ExampleX1_Scrollbars());
		RootLayoutPanel.get().add(exampleBrowser);
	}

}
