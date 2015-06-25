package fr.jdev.atelier.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TaskListPlace extends Place {

	public TaskListPlace() {
	}

	public static class Tokenizer implements PlaceTokenizer<TaskListPlace> {
		public TaskListPlace getPlace(String token) {
			return new TaskListPlace();
		}

		public String getToken(TaskListPlace place) {
			return "";
		}
	}
}