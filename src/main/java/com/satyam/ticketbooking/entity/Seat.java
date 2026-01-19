package com.satyam.ticketbooking.entity;

import com.satyam.ticketbooking.entity.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Table(name = "seat",
 indexes = {
         @Index(name = "idx_seat_status", columnList = "status"),
         @Index(name = "idx_seat_venue", columnList = "venue_id")
 }
)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    private LocalDateTime lockedAt;
    private LocalDateTime lockedUntil;
}
