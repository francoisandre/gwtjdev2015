package fr.jdev.atelier.client.view;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.jdev.atelier.shared.Task;

public class TaskConsultViewImpl extends VerticalPanel implements TaskConsultView {

	public TaskConsultViewImpl() {

	}

	@Override
	public void reset() {
		clear();

	}

	@Override
	public void display(Task task) {
		add(new Label(task.getDescription()));
		add(new Label(task.getResponsible()));
		add(new Label(task.getDeadLine().toString()));
	}

}
