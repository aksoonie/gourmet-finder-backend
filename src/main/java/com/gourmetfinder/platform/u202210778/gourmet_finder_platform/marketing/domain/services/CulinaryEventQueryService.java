package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.services;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.aggregates.CulinaryEvent;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.queries.GetAllCulinaryEventsQuery;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.queries.GetCulinaryEventByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CulinaryEventQueryService {
    List<CulinaryEvent> handle(GetAllCulinaryEventsQuery query);
    Optional<CulinaryEvent> handle(GetCulinaryEventByIdQuery query);
}
