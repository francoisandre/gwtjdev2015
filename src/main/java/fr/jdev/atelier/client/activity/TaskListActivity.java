package fr.jdev.atelier.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.jdev.atelier.client.ClientFactory;
import fr.jdev.atelier.client.place.TaskConsultPlace;
import fr.jdev.atelier.client.place.TaskListPlace;
import fr.jdev.atelier.client.view.TaskListView;
import fr.jdev.atelier.client.view.TaskListView.Presenter;

public class TaskListActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;
	private TaskListView taskListView;

	public TaskListActivity(TaskListPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, final EventBus eventBus) {
		taskListView = clientFactory.getTaskListView();
		taskListView.reset();
		containerWidget.setWidget(taskListView.asWidget());

	}

	@Override
	public void display(String taskUuid) {
		TaskConsultPlace taskConsultPlace = new TaskConsultPlace();
		taskConsultPlace.setTaskUuid(taskUuid);
		clientFactory.getPlaceController().goTo(taskConsultPlace);

	}

}