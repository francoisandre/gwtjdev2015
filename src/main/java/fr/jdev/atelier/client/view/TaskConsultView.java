package fr.jdev.atelier.client.view;

import com.google.gwt.user.client.ui.IsWidget;

import fr.jdev.atelier.shared.Task;

public interface TaskConsultView extends IsWidget {

	void reset();

	void display(Task task);

}
