package fr.jdev.atelier.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class NotificationEvent extends GwtEvent<NotificationEventHandler> {

	public static final Type<NotificationEventHandler> TYPE = new Type<NotificationEventHandler>();

	private String message;

	public NotificationEvent(String message) {
		this.setMessage(message);
	}

	@Override
	protected void dispatch(NotificationEventHandler handler) {
		handler.onNotification(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<NotificationEventHandler> getAssociatedType() {
		return TYPE;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
