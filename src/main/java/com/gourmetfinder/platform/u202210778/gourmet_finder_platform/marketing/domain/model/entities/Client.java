package com.gourmetfinder.platform.u202210778.gourmet_finder_platform.marketing.domain.model.entities;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    public Client(){

    }
    public Client (Long clientId){
        this.id=clientId;
    }

}
