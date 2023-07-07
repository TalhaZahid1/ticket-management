package com.personal.practice.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ticket")
public class Report {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID ticketId;

    @Column(name = "updatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "updatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Enumerated(EnumType.ORDINAL)
    private ReportStatus status;

    private String asignee;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ticket> ticketsList;
}
