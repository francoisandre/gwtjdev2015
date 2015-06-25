package fr.jdev.atelier.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TaskConsultPlace extends Place {

	private String taskUuid;

	public TaskConsultPlace() {
	}

	public String getTaskUuid() {
		return taskUuid;
	}

	public void setTaskUuid(String taskUuid) {
		this.taskUuid = taskUuid;
	}

	public static class Tokenizer implements PlaceTokenizer<TaskConsultPlace> {
		public TaskConsultPlace getPlace(String token) {
			TaskConsultPlace place = new TaskConsultPlace();
			place.setTaskUuid(token);
			return place;
		}

		public String getToken(TaskConsultPlace place) {
			return place.getTaskUuid();
		}
	}
}