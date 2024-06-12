package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.interfaces.rest.transform;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.commands.CreateCulinaryEventCommand;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.interfaces.rest.resources.CreateCulinaryEventResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class CreateCulinaryEventCommandFromResourceAssembler {
    public static CreateCulinaryEventCommand toCommandFromResource(CreateCulinaryEventResource resource) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date eventDate = null;
        try {
            eventDate = formatter.parse(resource.eventDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new CreateCulinaryEventCommand(resource.eventName(), resource.cuisineType(), resource.organizerId(), resource.location(), eventDate, resource.maxParticipants());
    }
}