package com.example.bookingbuses.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    @Id
    private String id;
    private String name;
    private String email;
    private String origin;
    private String destination;
    private String departureDate;
    private String departureTime;
    private Integer duration;

    @PrePersist
    public void initializeUUID() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
