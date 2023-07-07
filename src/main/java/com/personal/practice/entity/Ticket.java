package com.personal.practice.entity;

import javax.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID ticketId;

    private String content;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    private String technicalFeedback;

    private String updatedBy;

    @Column(name = "updatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
}
