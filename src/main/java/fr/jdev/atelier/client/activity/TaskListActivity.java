package fr.jdev.atelier.client.activity;

import java.util.ArrayList;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.jdev.atelier.client.ClientFactory;
import fr.jdev.atelier.client.place.TaskConsultPlace;
import fr.jdev.atelier.client.place.TaskListPlace;
import fr.jdev.atelier.client.service.TaskService;
import fr.jdev.atelier.client.service.TaskServiceAsync;
import fr.jdev.atelier.client.view.TaskListView;
import fr.jdev.atelier.client.view.TaskListView.Presenter;
import fr.jdev.atelier.shared.Task;

public class TaskListActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;
	private TaskListView taskListView;

	private static final TaskServiceAsync TASK_SERVICE = GWT.create(TaskService.class);

	public TaskListActivity(TaskListPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, final EventBus eventBus) {
		taskListView = clientFactory.getTaskListView();
		taskListView.setPresenter(this);
		taskListView.reset();
		containerWidget.setWidget(taskListView.asWidget());
		findAll();

	}

	private void findAll() {
		TASK_SERVICE.findAll(new AsyncCallback<ArrayList<Task>>() {

			@Override
			public void onSuccess(ArrayList<Task> result) {
				taskListView.displayTasks(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("KO");

			}
		});

	}

	@Override
	public void display(String taskUuid) {
		TaskConsultPlace taskConsultPlace = new TaskConsultPlace();
		taskConsultPlace.setTaskUuid(taskUuid);
		clientFactory.getPlaceController().goTo(taskConsultPlace);

	}

}