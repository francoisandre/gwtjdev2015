package fr.jdev.atelier.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

import fr.jdev.atelier.client.event.NotificationEventHandler;
import fr.jdev.atelier.client.view.TaskConsultView;
import fr.jdev.atelier.client.view.TaskListView;
import fr.jdev.atelier.client.view.WelcomeView;

public interface ClientFactory extends NotificationEventHandler {
	EventBus getEventBus();

	PlaceController getPlaceController();

	WelcomeView getWelcomeView();

	TaskConsultView getTaskConsultView();

	TaskListView getTaskListView();

}
