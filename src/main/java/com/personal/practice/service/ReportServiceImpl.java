package com.personal.practice.service;

import com.personal.practice.entity.Report;
import com.personal.practice.entity.Ticket;
import com.personal.practice.exception.service.ResourceNotFoundException;
import com.personal.practice.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public void assignReport(String assignee, String reportId) {
        Report report = getById(reportId);
        report.setAsignee(assignee);
        this.reportRepository.saveAndFlush(report);
    }

    public Report getById (String reportId)
    {
        this.verifyReportExists(reportId);
        return this.reportRepository.findById( UUID.fromString(reportId) ).get();
    }

    private void verifyReportExists(String reportId){
        Optional<Report> report = this.reportRepository.findById( UUID.fromString(reportId) );
        if (report.isEmpty())
        {
            throw new ResourceNotFoundException( "Report with id " + reportId + " not found" );
        }
    }
}
