package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.interfaces.rest.resources;

public record CreateCulinaryEventResource (Long client, String eventName, String cuisineType, Long organizerId, String location, String eventDate, Integer maxParticipants){
}
