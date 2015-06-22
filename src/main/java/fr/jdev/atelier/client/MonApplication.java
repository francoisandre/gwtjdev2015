package fr.jdev.atelier.client;

import org.gwtbootstrap3.client.ui.Container;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Jumbotron;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MonApplication implements EntryPoint {

	public void onModuleLoad() {
		Jumbotron jumbotron = new Jumbotron();
		Container container = new Container();
		Heading heading = new Heading(HeadingSize.H1);
		heading.setText("Ma Todo List");
		container.add(heading);
		jumbotron.add(container);
		VerticalPanel mainContent = new VerticalPanel();
		mainContent.setWidth("100%");
		mainContent.add(jumbotron);
		NewTaskCreationPanel taskCreationPanel = new NewTaskCreationPanel();
		mainContent.add(taskCreationPanel);
		RootPanel.get().add(mainContent);
	}
}
