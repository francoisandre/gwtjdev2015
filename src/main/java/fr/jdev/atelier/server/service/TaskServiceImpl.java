package fr.jdev.atelier.server.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.jdev.atelier.client.service.TaskService;
import fr.jdev.atelier.shared.Task;

public class TaskServiceImpl extends RemoteServiceServlet implements TaskService {

	ArrayList<Task> tasks = new ArrayList<>();

	public TaskServiceImpl() {
		fakeInit();
	}

	private void fakeInit() {
		for (int i = 0; i < 10; i++) {
			save(createTask(i));
		}
	}

	@Override
	public Task save(Task task) {
		task.setUuid(UUID.randomUUID().toString());
		tasks.add(task);
		return task;
	}

	@Override
	public ArrayList<Task> findLatest() {
		int maxElementCount = 5;
		int taskCount = tasks.size();
		if (taskCount < maxElementCount) {
			maxElementCount = taskCount;
		}
		ArrayList<Task> aux = new ArrayList<Task>(tasks.subList(taskCount - maxElementCount, taskCount));
		Collections.reverse(aux);
		return aux;
	}

	@Override
	public ArrayList<Task> findAll() {
		ArrayList<Task> aux = new ArrayList<Task>(tasks);
		Collections.reverse(aux);
		return aux;
	}

	public Task createTask(int count) {
		Task result = new Task();
		result.setResponsible("Resp. " + count);
		result.setDescription("Description. " + count);
		result.setDeadLine(new Date());
		return result;
	}

	@Override
	public Task findByUuid(String uuid) {
		for (Task task : tasks) {
			if (task.getUuid().compareTo(uuid) == 0) {
				return task;
			}
		}
		return null;
	}

}
