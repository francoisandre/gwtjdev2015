package fr.jdev.atelier.client.activity;

import java.util.ArrayList;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.jdev.atelier.client.ClientFactory;
import fr.jdev.atelier.client.event.NotificationEvent;
import fr.jdev.atelier.client.place.TaskConsultPlace;
import fr.jdev.atelier.client.place.TaskListPlace;
import fr.jdev.atelier.client.place.WelcomePlace;
import fr.jdev.atelier.client.service.TaskService;
import fr.jdev.atelier.client.service.TaskServiceAsync;
import fr.jdev.atelier.client.view.WelcomeView;
import fr.jdev.atelier.client.view.WelcomeView.Presenter;
import fr.jdev.atelier.shared.Task;

public class WelcomeActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;
	private WelcomeView welcomeView;

	private static final TaskServiceAsync TASK_SERVICE = GWT.create(TaskService.class);

	public WelcomeActivity(WelcomePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, final EventBus eventBus) {
		welcomeView = clientFactory.getWelcomeView();
		welcomeView.setPresenter(this);
		welcomeView.reset();
		containerWidget.setWidget(welcomeView.asWidget());
		findLatest();

	}

	private void findLatest() {
		TASK_SERVICE.findLatest(new AsyncCallback<ArrayList<Task>>() {

			@Override
			public void onSuccess(ArrayList<Task> result) {
				welcomeView.setRecentTask(result);

			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("KO");

			}
		});

	}

	@Override
	public void addTask(Task task) {
		TASK_SERVICE.save(task, new AsyncCallback<Task>() {

			@Override
			public void onSuccess(Task result) {
				clientFactory.getEventBus().fireEvent(new NotificationEvent("Saved"));
				findLatest();
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("KO");

			}
		});
	}

	@Override
	public void showList() {
		clientFactory.getPlaceController().goTo(new TaskListPlace());

	}

	@Override
	public void display(String taskUuid) {
		TaskConsultPlace taskConsultPlace = new TaskConsultPlace();
		taskConsultPlace.setTaskUuid(taskUuid);
		clientFactory.getPlaceController().goTo(taskConsultPlace);

	}

}