package fr.jdev.atelier.client;

import org.gwtbootstrap3.extras.growl.client.ui.Growl;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

import fr.jdev.atelier.client.event.NotificationEvent;
import fr.jdev.atelier.client.view.TaskConsultView;
import fr.jdev.atelier.client.view.TaskConsultViewImpl;
import fr.jdev.atelier.client.view.TaskListView;
import fr.jdev.atelier.client.view.TaskListViewImpl;
import fr.jdev.atelier.client.view.WelcomeView;
import fr.jdev.atelier.client.view.WelcomeViewImpl;

public class ClientFactoryImpl implements ClientFactory {

	private static final EventBus EVENT_BUS = new SimpleEventBus();
	private static final PlaceController PLACE_CONTROLLER = new PlaceController(EVENT_BUS);

	WelcomeView welcomeView = new WelcomeViewImpl();
	TaskListView taskListView = new TaskListViewImpl();
	TaskConsultView taskConsultView = new TaskConsultViewImpl();

	public ClientFactoryImpl() {
		getEventBus().addHandler(NotificationEvent.TYPE, this);
	}

	@Override
	public EventBus getEventBus() {
		return EVENT_BUS;
	}

	@Override
	public void onNotification(NotificationEvent event) {
		Growl.growl(event.getMessage());
	}

	@Override
	public PlaceController getPlaceController() {
		return PLACE_CONTROLLER;
	}

	@Override
	public WelcomeView getWelcomeView() {
		return welcomeView;
	}

	@Override
	public TaskConsultView getTaskConsultView() {
		return taskConsultView;
	}

	@Override
	public TaskListView getTaskListView() {
		return taskListView;
	}

}
