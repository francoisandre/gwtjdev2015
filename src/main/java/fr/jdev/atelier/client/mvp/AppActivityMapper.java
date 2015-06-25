package fr.jdev.atelier.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import fr.jdev.atelier.client.ClientFactory;
import fr.jdev.atelier.client.activity.TaskConsultActivity;
import fr.jdev.atelier.client.activity.TaskListActivity;
import fr.jdev.atelier.client.activity.WelcomeActivity;
import fr.jdev.atelier.client.place.TaskConsultPlace;
import fr.jdev.atelier.client.place.TaskListPlace;
import fr.jdev.atelier.client.place.WelcomePlace;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	/**
	 * Map each Place to its corresponding Activity. This would be a great use
	 * for GIN.
	 */
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof TaskConsultPlace) {
			return new TaskConsultActivity((TaskConsultPlace) place, clientFactory);
		} else if (place instanceof TaskListPlace) {
			return new TaskListActivity((TaskListPlace) place, clientFactory);
		} else {
			return new WelcomeActivity(new WelcomePlace(), clientFactory);
		}

	}

}
