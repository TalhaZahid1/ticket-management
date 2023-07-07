package com.personal.practice.service;

import com.personal.practice.entity.Ticket;
import com.personal.practice.entity.TicketStatus;

import java.util.List;

public interface TicketService {
    Ticket update(Ticket ticket, String id);

    void updateStatus(String id, TicketStatus status);

    List<Ticket> getAll();

}
