package com.personal.practice.controller;

import com.personal.practice.entity.Report;
import com.personal.practice.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/assign")
    public ResponseEntity<HttpStatus> assignReport(@RequestParam String assignee,
                                                   @RequestParam String reportId){
        ///asdfasdfasdfasdfasdf
        ///asdfasdfasdfasf
        reportService.assignReport(assignee,reportId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getReports")
    public List<Report> getReports(){
        return reportService.getReports();
    }
}

