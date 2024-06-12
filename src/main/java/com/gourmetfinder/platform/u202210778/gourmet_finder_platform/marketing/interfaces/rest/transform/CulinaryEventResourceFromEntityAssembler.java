package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.interfaces.rest.transform;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.aggregates.CulinaryEvent;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.interfaces.rest.resources.CulinaryEventResource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CulinaryEventResourceFromEntityAssembler {
    public static CulinaryEventResource toResourceFromEntity(CulinaryEvent entity){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String eventDateAsString = formatter.format(entity.getEventDate());

        return new CulinaryEventResource(entity.getId(), entity.getEventName(), entity.getCuisineType(), entity.getOrganizerId(), entity.getLocation(), eventDateAsString, entity.getMaxParticipants());
    }

}
