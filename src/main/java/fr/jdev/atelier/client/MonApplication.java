package fr.jdev.atelier.client;

import org.gwtbootstrap3.client.ui.Container;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Jumbotron;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.html.Div;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.jdev.atelier.client.mvp.AppActivityMapper;
import fr.jdev.atelier.client.mvp.AppPlaceHistoryMapper;
import fr.jdev.atelier.client.place.WelcomePlace;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MonApplication implements EntryPoint {

	private static ClientFactory clientFactory;
	private ContentPanel dynamicPanel = new ContentPanel();
	private Div staticContentPanel;

	public static ClientFactory getClientFactory() {
		if (clientFactory == null) {
			clientFactory = GWT.create(ClientFactory.class);
		}
		return clientFactory;
	}

	public void onModuleLoad() {
		clientFactory = getClientFactory();
		initGui();
		PlaceController placeController = getClientFactory().getPlaceController();

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(getClientFactory());
		ActivityManager activityManager = new ActivityManager(activityMapper, getClientFactory().getEventBus());
		activityManager.setDisplay(dynamicPanel);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, getClientFactory().getEventBus(), new WelcomePlace());
		historyHandler.handleCurrentHistory();

	}

	private void initGui() {
		staticContentPanel = new Div();

		Jumbotron jumbotron = new Jumbotron();
		Container container = new Container();
		Heading heading = new Heading(HeadingSize.H1);
		heading.setText("Ma Todo List");
		container.add(heading);
		jumbotron.add(container);
		staticContentPanel.add(jumbotron);
		staticContentPanel.add(dynamicPanel);

		RootPanel.get().add(staticContentPanel);
	}

	private class ContentPanel extends VerticalPanel implements AcceptsOneWidget {

		public ContentPanel() {
			super();
			setWidth("100%");
		}

		@Override
		public void setWidget(IsWidget w) {
			if (w != null) {
				clear();
				add(w.asWidget());
			}

		}

	}

}
