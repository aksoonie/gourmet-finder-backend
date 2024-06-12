package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.application.internal.queryservices;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.aggregates.CulinaryEvent;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.queries.GetAllCulinaryEventsQuery;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.queries.GetCulinaryEventByIdQuery;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.services.CulinaryEventQueryService;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.infrastructure.persistence.jpa.respositories.CulinaryEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CulinaryEventQueryServiceImpl implements CulinaryEventQueryService {
    private final CulinaryEventRepository culinaryEventRepository;

    public CulinaryEventQueryServiceImpl(CulinaryEventRepository culinaryEventRepository) {
        this.culinaryEventRepository = culinaryEventRepository;
    }

    @Override
    public List<CulinaryEvent> handle(GetAllCulinaryEventsQuery query) {
        return culinaryEventRepository.findAll();
    }
    @Override
    public Optional<CulinaryEvent> handle(GetCulinaryEventByIdQuery query) {
        return culinaryEventRepository.findById(query.id());
    }
}
