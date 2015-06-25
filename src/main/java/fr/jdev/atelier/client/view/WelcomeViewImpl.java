package fr.jdev.atelier.client.view;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.IconType;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.VerticalPanel;

import fr.jdev.atelier.client.NewTaskCreationPanel;
import fr.jdev.atelier.client.TaskListPanel;
import fr.jdev.atelier.shared.Task;

public class WelcomeViewImpl extends VerticalPanel implements WelcomeView {

	private NewTaskCreationPanel taskCreationPanel;
	private TaskListPanel taskListPanel;
	private Presenter presenter;

	public WelcomeViewImpl() {
		super();

		getElement().getStyle().setMargin(5, Unit.PX);
		getElement().getStyle().setBorderColor("white");
		getElement().getStyle().setBorderWidth(2, Unit.PCT);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);

		taskCreationPanel = new NewTaskCreationPanel();
		add(taskCreationPanel);
		Button addButton = new Button("Add");
		addButton.setIcon(IconType.PLUS);
		addButton.setType(ButtonType.PRIMARY);
		addButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.addTask(taskCreationPanel.flush());
			}
		});
		add(addButton);
		add(new Heading(HeadingSize.H2, "Latest"));
		taskListPanel = new TaskListPanel();

		add(taskListPanel);

		Button taskListButton = new Button("View all");
		taskListButton.getElement().getStyle().setMarginTop(5, Unit.PX);
		taskListButton.setIcon(IconType.LIST);
		taskListButton.setType(ButtonType.PRIMARY);
		taskListButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.showList();
			}
		});
		add(taskListButton);

		setWidth("98%");
	}

	@Override
	public void reset() {
		taskCreationPanel.reset();
		taskListPanel.reset();

	}

	@Override
	public void setRecentTask(ArrayList<Task> tasks) {
		taskListPanel.setTasks(tasks);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		taskListPanel.setPresenter(presenter);
	}

}
