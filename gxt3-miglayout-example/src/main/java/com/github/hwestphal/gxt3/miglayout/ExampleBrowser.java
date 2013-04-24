package com.github.hwestphal.gxt3.miglayout;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public class ExampleBrowser implements IsWidget {

	private static final String SOURCE_URL = "https://raw.github.com/hwestphal/gxt3-miglayout/master/gxt3-miglayout-example/src/main/java/";

	private final BorderLayoutContainer container;
	private VerticalLayoutContainer listBox;
	private TabPanel tabPanel;
	private Label descriptionArea;

	public ExampleBrowser() {
		container = new BorderLayoutContainer();
		container.setWestWidget(createBrowserPanel());
		container.setCenterWidget(createCenterPanel());
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
		FlowLayoutContainer container = new FlowLayoutContainer();
		container.setScrollMode(ScrollMode.AUTO);
		container.add(descriptionArea);
		contentPanel.add(container);
		return contentPanel;
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
		listBox = new VerticalLayoutContainer();
		listBox.setScrollMode(ScrollMode.AUTO);
		contentPanel.add(listBox);
		return contentPanel;
	}

	@Override
	public Widget asWidget() {
		return container;
	}

	public void addExample(final ExampleItem example) {
		final Label label = new Label(example.getTitle(), false);
		label.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				markExample(label);
				showExample(example);
			}
		});
		listBox.add(label);
	}

	private void markExample(Widget label) {
		for (int i = 0; i < listBox.getWidgetCount(); i++) {
			listBox.getWidget(i).setStyleName("selectedExample", false);
		}
		label.setStyleName("selectedExample", true);
	}

	private void showExample(ExampleItem example) {
		descriptionArea.setText(example.getDescription());
		while (tabPanel.getWidgetCount() > 0) {
			tabPanel.remove(0);
		}
		for (ExampleTab exampleTab : example.getExampleTabs()) {
			tabPanel.add(exampleTab, new TabItemConfig(exampleTab.getTitle(), false));
		}
	}

}
