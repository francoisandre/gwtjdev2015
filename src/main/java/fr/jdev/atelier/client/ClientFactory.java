package fr.jdev.atelier.client;

import com.google.gwt.event.shared.EventBus;

import fr.jdev.atelier.client.event.NotificationEventHandler;

public interface ClientFactory extends NotificationEventHandler {
	EventBus getEventBus();

}
