package fr.jdev.atelier.client;

import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class TaskCreationPanel implements IsWidget {

	private VerticalPanel mainContainer;
	private TextBox description;
	private TextBox responsible;
	private DateBox deadLine;

	public TaskCreationPanel() {
		mainContainer = new VerticalPanel();
		mainContainer.setSpacing(5);
		mainContainer.add(new Label("Ma tâche"));
		description = new TextBox();
		HorizontalPanel descriptionPanel = new HorizontalPanel();
		descriptionPanel.add(description);
		descriptionPanel.add(new HelpTooltip("Indiquez ici la description"));
		description.setPlaceholder("Description");
		responsible = new TextBox();
		responsible.setPlaceholder("Responsible");
		deadLine = new DateBox();
		mainContainer.add(descriptionPanel);
		mainContainer.add(responsible);
		mainContainer.add(deadLine);
	}

	@Override
	public Widget asWidget() {
		return mainContainer;
	}

}
