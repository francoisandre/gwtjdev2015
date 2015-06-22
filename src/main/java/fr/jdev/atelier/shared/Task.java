package fr.jdev.atelier.shared;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Task implements IsSerializable {

	private String description;
	private String responsible;
	private Date deadLine;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

}
