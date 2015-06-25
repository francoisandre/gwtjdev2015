package fr.jdev.atelier.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.jdev.atelier.shared.Task;

@RemoteServiceRelativePath("tasks")
public interface TaskService extends RemoteService {

	Task save(Task task);

	ArrayList<Task> findLatest();

	ArrayList<Task> findAll();

	Task findByUuid(String uuid);

}
