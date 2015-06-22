package fr.jdev.atelier.client;

import org.gwtbootstrap3.client.ui.Container;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Jumbotron;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MonApplication implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Jumbotron jumbotron = new Jumbotron();
		Container container = new Container();
		Heading heading = new Heading(HeadingSize.H1);
		heading.setText("Ma Todo List");
		container.add(heading);
		jumbotron.add(container);

		VerticalPanel mainContent = new VerticalPanel();
		mainContent.setWidth("100%");
		VerticalPanel taskForm = new VerticalPanel();

		taskForm.setSpacing(5);
		taskForm.add(new Label("Ma tâche"));
		TextBox description = new TextBox();
		description.setPlaceholder("Description");
		TextBox responsible = new TextBox();
		responsible.setPlaceholder("Responsible");
		DateBox deadLine = new DateBox();
		taskForm.add(description);
		taskForm.add(responsible);
		taskForm.add(deadLine);

		mainContent.add(jumbotron);
		mainContent.add(taskForm);

		RootPanel.get().add(mainContent);

	}
}
