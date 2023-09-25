package com.personal.practice.controller;

import com.personal.practice.entity.Ticket;
import com.personal.practice.entity.TicketStatus;
import com.personal.practice.factory.TicketModelImpl;
import com.personal.practice.model.TicketModel;
import com.personal.practice.service.TicketService;
import com.personal.practice.service.TicketServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketModel ticketModel;

    @Autowired
    private TicketModelImpl ticketModelImpl;

    @PostMapping("/updateStatus")
    ResponseEntity<HttpStatus> updateStatus( @RequestParam ( "ticketId" ) String ticketId,
                         @RequestParam ( "status" ) String status){
//        ticketService.updateStatus(ticketId,TicketStatus.valueOf(status));
        System.out.println(ticketModel != null);
        System.out.println(ticketModel.getTicketsFromService());
        System.out.println(ticketModelImpl.getAllTickets());
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @PostMapping("/addTicket")
    ResponseEntity<HttpStatus> addTicket(@RequestBody TicketModel ticketModel){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    List<Ticket> getAll(){
        return ticketService.getAll();
    }

}
