package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.infrastructure.persistence.jpa.respositories;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.aggregates.CulinaryEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
/**
 * Repository for CulinaryEvent
 * existsByEventNameAndCuisineTypeAndLocation and existsByOrganizerIdAndEventDate
 * are used to check if the event already exists con estas caracteríticas
 */
@Repository
public interface CulinaryEventRepository extends JpaRepository<CulinaryEvent, Long> {
    boolean existsByEventNameAndCuisineTypeAndLocation(String eventName, String cuisineType, String location);
    boolean existsByOrganizerIdAndEventDate(Long organizerId, Date eventDate);
}
