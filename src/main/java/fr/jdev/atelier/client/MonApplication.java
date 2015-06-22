package fr.jdev.atelier.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
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
		DockLayoutPanel mainContent = new DockLayoutPanel(Unit.PX);
		mainContent.getElement().getStyle().setMargin(5, Unit.PX);
		mainContent.addNorth(new Label("Ma Todo List"), 25);
		VerticalPanel taskForm = new VerticalPanel();
		taskForm.setSpacing(5);
		taskForm.add(new Label("Ma tâche"));
		TextBox description = new TextBox();
		description.setTitle("Description");
		TextBox responsible = new TextBox();
		responsible.setTitle("Responsible");
		DateBox deadLine = new DateBox();
		taskForm.add(description);
		taskForm.add(responsible);
		taskForm.add(deadLine);
		mainContent.add(taskForm);
		RootLayoutPanel.get().add(mainContent);
	}

}
