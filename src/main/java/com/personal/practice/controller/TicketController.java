package com.personal.practice.controller;

import com.personal.practice.entity.Ticket;
import com.personal.practice.entity.TicketStatus;
import com.personal.practice.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/updateStatus")
    ResponseEntity<HttpStatus> updateStatus( @RequestParam ( "ticketId" ) Long ticketId,
                         @RequestParam ( "status" ) TicketStatus status){
        ticketService.updateStatus(Long.toString(ticketId),status);
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @GetMapping("/getAll")
    List<Ticket> getAll(){
        return ticketService.getAll();
    }

}
