package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.application.internal.commandservices;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.aggregates.CulinaryEvent;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.commands.CreateCulinaryEventCommand;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.commands.DeleteCulinaryEventCommand;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.services.CulinaryEventCommandService;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.infrastructure.persistence.jpa.respositories.CulinaryEventRepository;
import org.springframework.stereotype.Service;

@Service
public class CulinaryEventCommandServiceImpl implements CulinaryEventCommandService {
    CulinaryEventRepository culinaryEventRepository;
    CulinaryEventCommandServiceImpl(CulinaryEventRepository culinaryEventRepository) {
        this.culinaryEventRepository = culinaryEventRepository;
    }
    @Override
    public Long handle(CreateCulinaryEventCommand command) {
        if (culinaryEventRepository.existsByEventNameAndCuisineTypeAndLocation(command.eventName(), command.cuisineType(), command.location())) {
                throw new RuntimeException("Event already exists by name, cuisine type and location");
        }
        if (culinaryEventRepository.existsByOrganizerIdAndEventDate(command.organizerId(), command.eventDate())) {
            throw new RuntimeException("Event already exists by organizer on the same day");
        }
        var event = new CulinaryEvent(command.eventName(), command.cuisineType(), command.organizerId(), command.location(), command.eventDate(), command.maxParticipants());
        try {
            culinaryEventRepository.save(event);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving course: " + e.getMessage());
        }
        return event.getId();
    }

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
