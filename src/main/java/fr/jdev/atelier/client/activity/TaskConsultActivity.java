package fr.jdev.atelier.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.jdev.atelier.client.ClientFactory;
import fr.jdev.atelier.client.place.TaskConsultPlace;
import fr.jdev.atelier.client.service.TaskService;
import fr.jdev.atelier.client.service.TaskServiceAsync;
import fr.jdev.atelier.client.view.TaskConsultView;
import fr.jdev.atelier.shared.Task;

public class TaskConsultActivity extends AbstractActivity {

	private ClientFactory clientFactory;
	private TaskConsultView taskConsultView;
	private String taskUuid;
	private static final TaskServiceAsync TASK_SERVICE = GWT.create(TaskService.class);

	public TaskConsultActivity(TaskConsultPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		taskUuid = place.getTaskUuid();
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, final EventBus eventBus) {
		taskConsultView = clientFactory.getTaskConsultView();
		taskConsultView.reset();
		containerWidget.setWidget(taskConsultView.asWidget());
		TASK_SERVICE.findByUuid(taskUuid, new AsyncCallback<Task>() {

			@Override
			public void onSuccess(Task result) {
				taskConsultView.display(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("KO");

			}
		});
	}
}