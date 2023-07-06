package com.personal.practice.controller;

import com.personal.practice.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(name = "/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping(name = "/assign")
    public ResponseEntity<HttpStatus> assignReport(@RequestParam String assignee,
                                                   @RequestParam String reportId){
        reportService.assignReport(assignee,reportId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
