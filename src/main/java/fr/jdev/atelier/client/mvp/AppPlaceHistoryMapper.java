package fr.jdev.atelier.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

import fr.jdev.atelier.client.place.TaskConsultPlace;
import fr.jdev.atelier.client.place.TaskListPlace;
import fr.jdev.atelier.client.place.WelcomePlace;

/**
 * PlaceHistoryMapper interface is used to attach all places which the
 * PlaceHistoryHandler should be aware of. This is done via the @WithTokenizers
 * annotation or by extending PlaceHistoryMapperWithFactory and creating a
 * separate TokenizerFactory.
 */
@WithTokenizers({ WelcomePlace.Tokenizer.class, TaskConsultPlace.Tokenizer.class, TaskListPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
