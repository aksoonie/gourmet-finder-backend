package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.commands;

import java.util.Date;

public record CreateCulinaryEventCommand(String eventName, String cuisineType, Long organizerId, String location, Date eventDate, Integer maxParticipants) {
}
