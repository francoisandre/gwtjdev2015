package fr.jdev.atelier.client;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.jdev.atelier.client.place.TaskConsultPlace;
import fr.jdev.atelier.client.view.DetailPresenter;
import fr.jdev.atelier.shared.Task;

public class TaskListPanel extends VerticalPanel {

	private DetailPresenter presenter;

	public TaskListPanel() {
		super();
		setWidth("100%");
	}

	public void reset() {
		clear();
	}

	public void setTasks(ArrayList<Task> tasks) {
		reset();
		int i = 0;
		Grid grid = new Grid(tasks.size(), 4);
		grid.setWidth("100%");
		for (Task task : tasks) {
			grid.setWidget(i, 0, new Label(task.getDescription()));
			grid.setWidget(i, 1, new Label(task.getResponsible()));
			grid.setWidget(i, 2, new Label(task.getDeadLine().toString()));

			Button detailButton = new Button("Detail");
			detailButton.setType(ButtonType.PRIMARY);
			detailButton.setSize(ButtonSize.SMALL);
			final String uuid = task.getUuid();
			detailButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					TaskConsultPlace taskConsultPlace = new TaskConsultPlace();
					taskConsultPlace.setTaskUuid(uuid);
					MonApplication.getClientFactory().getPlaceController().goTo(taskConsultPlace);
				}
			});
			grid.setWidget(i, 3, detailButton);
			i++;
		}
		add(grid);
	}

	public void setPresenter(DetailPresenter presenter) {
		this.presenter = presenter;
	}

}
