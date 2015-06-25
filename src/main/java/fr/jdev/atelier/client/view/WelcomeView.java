package fr.jdev.atelier.client.view;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.IsWidget;

import fr.jdev.atelier.shared.Task;

public interface WelcomeView extends IsWidget {

	void reset();

	void setRecentTask(ArrayList<Task> tasks);

	void setPresenter(Presenter presenter);

	public interface Presenter extends DetailPresenter {
		void addTask(Task task);

		void showList();
	}
}
