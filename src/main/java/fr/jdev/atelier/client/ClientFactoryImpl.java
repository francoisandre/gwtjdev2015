package fr.jdev.atelier.client;

import org.gwtbootstrap3.extras.growl.client.ui.Growl;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

import fr.jdev.atelier.client.event.NotificationEvent;

public class ClientFactoryImpl implements ClientFactory {

	private static final EventBus EVENT_BUS = new SimpleEventBus();

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

}
