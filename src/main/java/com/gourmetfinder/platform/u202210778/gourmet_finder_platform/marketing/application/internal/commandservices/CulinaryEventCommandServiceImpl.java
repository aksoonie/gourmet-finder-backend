package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.application.internal.commandservices;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.aggregates.CulinaryEvent;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.commands.CreateCulinaryEventCommand;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.commands.DeleteCulinaryEventCommand;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.entities.Client;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.services.CulinaryEventCommandService;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.infrastructure.persistence.jpa.respositories.CulinaryEventRepository;
import org.springframework.stereotype.Service;

@Service
public class CulinaryEventCommandServiceImpl implements CulinaryEventCommandService {
    CulinaryEventRepository culinaryEventRepository;
    CulinaryEventCommandServiceImpl(CulinaryEventRepository culinaryEventRepository) {
        this.culinaryEventRepository = culinaryEventRepository;
    }

    /**
     * Create a new CulinaryEvent
     * @param command the command to create a new CulinaryEvent
     * @throws RuntimeException if an event already exists by name, cuisine type and location
     * @throws RuntimeException if an event already exists by organizer on the same day
     * @throws IllegalArgumentException if there is an error while saving the event
     * @return the id of the created event
     * @author Jimena Cama - U202210778
     */
    @Override
    public Long handle(CreateCulinaryEventCommand command) {
        if (culinaryEventRepository.existsByEventNameAndCuisineTypeAndLocation(command.eventName(), command.cuisineType(), command.location())) {
                throw new RuntimeException("Event already exists by name, cuisine type and location");
        }
        if (culinaryEventRepository.existsByOrganizerIdAndEventDate(command.organizerId(), command.eventDate())) {
            throw new RuntimeException("Event already exists by organizer on the same day");
        }
        var event = new CulinaryEvent(new Client(command.clientId()), command.eventName(), command.cuisineType(), command.organizerId(), command.location(), command.eventDate(), command.maxParticipants());
        try {
            culinaryEventRepository.save(event);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving course: " + e.getMessage());
        }
        return event.getId();
    }

    /**
     * Delete a CulinaryEvent
     * @param command the command to delete a CulinaryEvent
     * @throws IllegalArgumentException if the event does not exist
     * @throws IllegalArgumentException if there is an error while deleting the event
     * @author Jimena Cama - U202210778
     */
    @Override
    public void handle(DeleteCulinaryEventCommand command) {
        if (!culinaryEventRepository.existsById(command.id())) {
            throw new IllegalArgumentException("Event does not exist");
        }
        try {
            culinaryEventRepository.deleteById(command.id());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting event: " + e.getMessage());
        }
    }
}
