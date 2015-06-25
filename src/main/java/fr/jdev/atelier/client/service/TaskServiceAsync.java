package fr.jdev.atelier.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.jdev.atelier.shared.Task;

public interface TaskServiceAsync {

	void findAll(AsyncCallback<ArrayList<Task>> callback);

	void findLatest(AsyncCallback<ArrayList<Task>> callback);

	void save(Task task, AsyncCallback<Task> callback);

	void findByUuid(String uuid, AsyncCallback<Task> callback);

}
