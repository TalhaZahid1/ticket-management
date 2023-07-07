package com.personal.practice.service;

import com.personal.practice.entity.Report;

import java.util.List;

public interface ReportService {
    void assignReport(String assignee, String reportId);

    List<Report> getReports();
}
