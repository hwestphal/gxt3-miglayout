package com.github.hwestphal.gxt3.miglayout;

import java.util.IdentityHashMap;
import java.util.Map;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class ExampleBrowser implements IsWidget {

	private static final String SOURCE_BASE_URL = "https://raw.github.com/hwestphal/gxt3-miglayout/master/gxt3-miglayout-example/src/main/java/";
	private static final String SELECTED_EXAMPLE_STYLE = "selected-example";

	private final Map<Widget, String> exampleSources = new IdentityHashMap<Widget, String>();
	private final BorderLayoutContainer rootContainer;
	private FlowLayoutContainer exampleBrowser;
	private TabPanel tabPanel;
	private Label descriptionArea;
	private ToolButton downloadButton;

	public ExampleBrowser() {
		rootContainer = new BorderLayoutContainer();
		rootContainer.setWestWidget(createBrowserPanel());
		rootContainer.setCenterWidget(createCenterPanel());
	}

	private IsWidget createCenterPanel() {
		BorderLayoutContainer centerContainer = new BorderLayoutContainer();
		centerContainer.setCenterWidget(createTabPanel());
		centerContainer.setSouthWidget(createDescriptionPanel());
		return centerContainer;
	}

	private IsWidget createDescriptionPanel() {
		ContentPanel contentPanel = new ContentPanel();
		contentPanel.setHeadingText("Description");
		BorderLayoutData layoutData = new BorderLayoutData(.20);
		layoutData.setMargins(new Margins(0, 5, 5, 0));
		layoutData.setCollapsible(true);
		layoutData.setSplit(true);
		layoutData.setCollapseMini(true);
		contentPanel.setLayoutData(layoutData);
		descriptionArea = new Label();
		descriptionArea.setLayoutData(new MarginData(5));
		FlowLayoutContainer container = new FlowLayoutContainer();
		container.setScrollMode(ScrollMode.AUTO);
		container.add(descriptionArea);
		contentPanel.add(container);
		contentPanel.addTool(createDownloadButton());
		return contentPanel;
	}

	private Widget createDownloadButton() {
		downloadButton = new ToolButton(ToolButton.GEAR);
		downloadButton.setToolTip("Open source code");
		downloadButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				String path = exampleSources.get(tabPanel.getActiveWidget());
				Window.open(SOURCE_BASE_URL + path, "_blank", "");
			}
		});
		downloadButton.setVisible(false);
		return downloadButton;
	}

	private IsWidget createTabPanel() {
		tabPanel = new TabPanel();
		BorderLayoutData layoutData = new BorderLayoutData();
		layoutData.setMargins(new Margins(0, 5, 5, 0));
		tabPanel.setLayoutData(layoutData);
		return tabPanel;
	}

	private IsWidget createBrowserPanel() {
		ContentPanel contentPanel = new ContentPanel();
		contentPanel.setHeadingText("Example Browser");
		BorderLayoutData layoutData = new BorderLayoutData(.15);
		layoutData.setMargins(new Margins(0, 5, 5, 5));
		layoutData.setCollapsible(true);
		layoutData.setSplit(true);
		layoutData.setCollapseMini(true);
		contentPanel.setLayoutData(layoutData);
		exampleBrowser = new FlowLayoutContainer();
		exampleBrowser.setScrollMode(ScrollMode.AUTO);
		contentPanel.add(exampleBrowser);
		return contentPanel;
	}

	@Override
	public Widget asWidget() {
		return rootContainer;
	}

	public void addExample(final ExampleItem example) {
		final Label label = new Label(example.getTitle(), false);
		label.setLayoutData(new MarginData(5));
		label.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				label.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});
		label.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				markExample(label);
				showExample(example);
			}
		});
		exampleBrowser.add(label);
	}

	private void markExample(Widget label) {
		for (int i = 0; i < exampleBrowser.getWidgetCount(); i++) {
			exampleBrowser.getWidget(i).setStyleName(SELECTED_EXAMPLE_STYLE, false);
		}
		label.setStyleName(SELECTED_EXAMPLE_STYLE, true);
	}

	private void showExample(ExampleItem example) {
		downloadButton.setVisible(true);
		descriptionArea.setText(example.getDescription());
		while (tabPanel.getWidgetCount() > 0) {
			tabPanel.remove(0);
		}
		exampleSources.clear();
		for (ExampleTab exampleTab : example.getExampleTabs()) {
			tabPanel.add(exampleTab, new TabItemConfig(exampleTab.getTitle(), false));
			exampleSources.put(exampleTab.asWidget(), exampleTab.getSourcePath());
		}
	}

}