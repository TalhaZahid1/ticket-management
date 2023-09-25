package com.personal.practice.factory;

import com.personal.practice.entity.Ticket;
import com.personal.practice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketModelImpl implements TicketModelInterface{

    @Autowired
    TicketService ticketService;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketService.getAll();
    }
}
