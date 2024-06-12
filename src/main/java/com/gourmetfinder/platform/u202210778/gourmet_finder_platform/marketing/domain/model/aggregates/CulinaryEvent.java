package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.aggregates;

import com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.entities.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a culinary event.
 * The culinary event is an entity that represents
 * a culinary event that can be organized by a user
 * @author Jimena Cama
*/
@Getter
@Entity
public class CulinaryEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @NotBlank
    private String eventName;

    @NotBlank
    private String cuisineType;

    @NotNull
    private Long organizerId;

    @NotBlank
    private String location;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    @NotNull
    @Min(1)
    private Integer maxParticipants;

    public CulinaryEvent(String eventName, String cuisineType, Long organizerId, String location, Date eventDate, Integer maxParticipants) {
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