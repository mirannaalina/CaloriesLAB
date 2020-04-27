package com.calories.caloriesproject.service;

import org.springframework.core.io.InputStreamResource;

import java.util.Map;

public interface Html2PdfService {

    InputStreamResource generatePDF(Map<String, Object> data);
}
