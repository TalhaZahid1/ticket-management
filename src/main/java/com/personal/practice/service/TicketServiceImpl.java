package com.personal.practice.service;

import com.personal.practice.entity.Ticket;
import com.personal.practice.entity.TicketStatus;
import com.personal.practice.exception.service.ResourceNotFoundException;
import com.personal.practice.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket update(Ticket ticket, String id) {
        Optional<Ticket> ticketFromDB =  ticketRepository.findById(UUID.fromString(id));
        return ticketFromDB.map(value -> ticketRepository.saveAndFlush(Ticket.builder()
                .ticketId(value.getTicketId())
                .updatedBy(ticket.getUpdatedBy())
                .ticketStatus(ticket.getTicketStatus())
                .content(ticket.getContent())
                .updatedDate(new Date())
                .technicalFeedback(ticket.getTechnicalFeedback())
                .build())).orElse(null);
    }

    @Override
    public void updateStatus(String ticketId, TicketStatus status) {
        verifyTicketExists(ticketId);
        Ticket ticket = this.getById(ticketId);
        ticket.setTicketStatus(status);
        this.ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAll() {
        return this.ticketRepository.findAll();
    }

    public Ticket getById (String ticketId)
    {
        this.verifyTicketExists(ticketId);
        return this.ticketRepository.findById( UUID.fromString(ticketId) ).get();
    }

    private void verifyTicketExists(String id){
        Optional<Ticket> ticket = this.ticketRepository.findById( UUID.fromString(id) );
        if (ticket.isEmpty())
        {
            throw new ResourceNotFoundException( "Ticket with id " + id + " not found" );
        }
    }

}
