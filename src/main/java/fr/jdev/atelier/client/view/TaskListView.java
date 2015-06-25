package fr.jdev.atelier.client.view;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.IsWidget;

import fr.jdev.atelier.shared.Task;

public interface TaskListView extends IsWidget {

	void reset();

	void displayTasks(ArrayList<Task> tasks);

	void setPresenter(Presenter presenter);

	public interface Presenter {
		void display(String taskUuid);
	}

}
