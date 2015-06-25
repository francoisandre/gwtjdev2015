package fr.jdev.atelier.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.jdev.atelier.client.ClientFactory;
import fr.jdev.atelier.client.place.TaskListPlace;
import fr.jdev.atelier.client.place.WelcomePlace;
import fr.jdev.atelier.client.view.WelcomeView;
import fr.jdev.atelier.client.view.WelcomeView.Presenter;
import fr.jdev.atelier.shared.Task;

public class WelcomeActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;
	private WelcomeView welcomeView;

	public WelcomeActivity(WelcomePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, final EventBus eventBus) {
		welcomeView = clientFactory.getWelcomeView();
		welcomeView.setPresenter(this);
		welcomeView.reset();
		containerWidget.setWidget(welcomeView.asWidget());

	}

	@Override
	public void addTask(Task task) {
		Window.alert("A coder dans le prochain exercice");
	}

	@Override
	public void showList() {
		clientFactory.getPlaceController().goTo(new TaskListPlace());

	}

}