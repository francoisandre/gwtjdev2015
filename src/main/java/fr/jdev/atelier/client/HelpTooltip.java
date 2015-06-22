package fr.jdev.atelier.client;

import org.gwtbootstrap3.client.ui.Icon;
import org.gwtbootstrap3.client.ui.Popover;
import org.gwtbootstrap3.client.ui.constants.IconSize;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.Placement;

import com.google.gwt.uibinder.client.UiConstructor;

public class HelpTooltip extends Popover {
	@UiConstructor
	public HelpTooltip(String text) {
		super();
		Icon helpIcon = new Icon(IconType.QUESTION_CIRCLE);
		helpIcon.setSize(IconSize.LARGE);
		add(helpIcon);
		setTitle("");
		setContent(text);
	}

	public HelpTooltip(String text, Placement placement) {
		this(text);
		setPlacement(placement);
	}

	public void setText(String text) {
		setContent(text);
	}
}