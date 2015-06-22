package fr.jdev.atelier.client;

import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimePicker;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import fr.jdev.atelier.shared.Task;

public class NewTaskCreationPanel extends Composite {

	@UiField
	TextBox description;

	@UiField
	TextBox responsible;

	@UiField
	DateTimePicker deadLine;

	private static LocalUiBinder uiBinder = GWT.create(LocalUiBinder.class);

	interface LocalUiBinder extends UiBinder<Widget, NewTaskCreationPanel> {
	}

	public NewTaskCreationPanel() {
		super();
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void reset() {
		description.setText("");
		responsible.setText("");
		deadLine.setValue(null);
	}

	public Task flush() {
		Task result = new Task();
		result.setResponsible(responsible.getText());
		result.setDescription(description.getText());
		result.setDeadLine(deadLine.getValue());
		return result;
	}

}
