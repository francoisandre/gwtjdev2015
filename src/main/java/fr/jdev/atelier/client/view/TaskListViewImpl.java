package fr.jdev.atelier.client.view;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.jdev.atelier.client.TaskListPanel;
import fr.jdev.atelier.shared.Task;

public class TaskListViewImpl extends VerticalPanel implements TaskListView {

	private Presenter presenter;
	private TaskListPanel taskListPanel;

	public TaskListViewImpl() {
		super();
		setWidth("100%");
		getElement().getStyle().setMargin(5, Unit.PX);
		getElement().getStyle().setBorderColor("white");
		getElement().getStyle().setBorderWidth(2, Unit.PCT);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);

		Heading title = new Heading(HeadingSize.H2);
		title.setText("Task List");
		add(title);
		taskListPanel = new TaskListPanel();

		add(taskListPanel);

	}

	@Override
	public void reset() {
		taskListPanel.reset();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		taskListPanel.setPresenter(presenter);
	}

	@Override
	public void displayTasks(ArrayList<Task> tasks) {
		taskListPanel.reset();
		taskListPanel.setTasks(tasks);

	}

}
