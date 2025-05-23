package com.azadkaya.ticketapp.model;

import com.azadkaya.ticketapp.utils.TicketEnumStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String category;

    @Enumerated(EnumType.STRING)
    private TicketEnumStatus status;

    private String adminResponse;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
