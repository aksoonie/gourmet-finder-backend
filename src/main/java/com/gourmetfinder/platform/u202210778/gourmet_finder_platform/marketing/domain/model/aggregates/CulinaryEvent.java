package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.aggregates;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.entities.Client;
import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

/**
 * Represents a culinary event.
 * The culinary event is an entity that represents
 * a culinary event that can be organized by a user
 * a client can have multiple culinary events
 * @author Jimena Cama
*/
@Getter
@Entity
public class CulinaryEvent extends AuditableAbstractAggregateRoot<CulinaryEvent> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @NotBlank
    private String eventName;

    @NotBlank
    private String cuisineType;

    @NotNull
    private Long organizerId;

    @NotBlank
    @Size(max = 15, message = "The location must be a maximum of 15 characters")
    private String location;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    @NotNull
    @Min(1)
    private Integer maxParticipants;

    public CulinaryEvent(Client client, String eventName, String cuisineType, Long organizerId, String location, Date eventDate, Integer maxParticipants) {
        this.client=client;
        this.eventName = eventName;
        this.cuisineType = cuisineType;
        this.organizerId = organizerId;
        this.location = location;
        this.eventDate = eventDate;
        this.maxParticipants = maxParticipants;
    }

    public CulinaryEvent() {
        this.eventName = "";
        this.cuisineType = "";
        this.organizerId = 0L;
        this.location = "";
        this.eventDate = new Date();
        this.maxParticipants = 0;
    }
}
