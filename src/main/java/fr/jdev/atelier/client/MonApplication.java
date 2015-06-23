package fr.jdev.atelier.client;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Container;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Jumbotron;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.IconType;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.jdev.atelier.client.event.NotificationEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MonApplication implements EntryPoint {

	private static ClientFactory clientFactory;

	public static ClientFactory getClientFactory() {
		if (clientFactory == null) {
			clientFactory = GWT.create(ClientFactory.class);
		}
		return clientFactory;
	}

	public void onModuleLoad() {
		clientFactory = getClientFactory();
		Jumbotron jumbotron = new Jumbotron();
		Container container = new Container();
		Heading heading = new Heading(HeadingSize.H1);
		heading.setText("Ma Todo List");
		container.add(heading);
		jumbotron.add(container);
		VerticalPanel mainContent = new VerticalPanel();
		mainContent.getElement().getStyle().setMargin(5, Unit.PX);
		mainContent.getElement().getStyle().setBorderColor("white");
		mainContent.getElement().getStyle().setBorderWidth(2, Unit.PCT);
		mainContent.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		mainContent.add(jumbotron);
		NewTaskCreationPanel taskCreationPanel = new NewTaskCreationPanel();
		mainContent.add(taskCreationPanel);
		Button addButton = new Button("Add");
		addButton.setIcon(IconType.PLUS);
		addButton.setType(ButtonType.PRIMARY);
		addButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				getClientFactory().getEventBus().fireEvent(new NotificationEvent("Task added..."));
			}
		});
		mainContent.add(addButton);
		mainContent.setWidth("98%");
		RootPanel.get().add(mainContent);
	}

}
