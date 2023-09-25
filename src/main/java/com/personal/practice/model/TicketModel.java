package com.personal.practice.model;

import com.personal.practice.entity.Ticket;
import com.personal.practice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketModel {

    @Autowired
    private TicketService ticketService;

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Ticket> getTicketsFromService(){
        return ticketService.getAll();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
