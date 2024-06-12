package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.entities;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.aggregates.CulinaryEvent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * Represents a reservation.
 * The reservation is an entity,
 * represents a reservation of a culinary event.
 * @author Jimena Cama
*/


@Entity
@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "culinary_event_id")
    private CulinaryEvent event;

    @NotNull
    private Long participantId;

    public Reservation(Long participantId) {
        this.participantId = participantId;
    }
    public Reservation() {
    }
}
