package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.commands;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.entities.Client;

import java.util.Date;

public record CreateCulinaryEventCommand(Long clientId, String eventName, String cuisineType, Long organizerId, String location, Date eventDate, Integer maxParticipants) {
}
