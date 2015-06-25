package fr.jdev.atelier.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.jdev.atelier.client.ClientFactory;
import fr.jdev.atelier.client.place.TaskConsultPlace;
import fr.jdev.atelier.client.view.TaskConsultView;

public class TaskConsultActivity extends AbstractActivity {

	private ClientFactory clientFactory;
	private TaskConsultView taskConsultView;
	private String taskUuid;

	public TaskConsultActivity(TaskConsultPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		taskUuid = place.getTaskUuid();
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, final EventBus eventBus) {
		taskConsultView = clientFactory.getTaskConsultView();
		taskConsultView.reset();
		containerWidget.setWidget(taskConsultView.asWidget());

	}

}