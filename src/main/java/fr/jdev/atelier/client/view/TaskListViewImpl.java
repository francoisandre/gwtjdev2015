package fr.jdev.atelier.client.view;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.jdev.atelier.shared.Task;

public class TaskListViewImpl extends VerticalPanel implements TaskListView {

	private Presenter presenter;

	public TaskListViewImpl() {
		super();

		getElement().getStyle().setMargin(5, Unit.PX);
		getElement().getStyle().setBorderColor("white");
		getElement().getStyle().setBorderWidth(2, Unit.PCT);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);

		Heading title = new Heading(HeadingSize.H2);
		title.setText("Task List");

		add(title);

	}

	@Override
	public void reset() {

	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void displayTasks(ArrayList<Task> tasks) {

	}

}
