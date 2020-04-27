package com.calories.caloriesproject.controller;

import com.calories.caloriesproject.service.Html2PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class Html2PdfRestController {

    private final Html2PdfService pdfService;

 //   @GetMapping("/html2pdf")
 //   public ResponseEntity html2pdf(Map<String, Object> data){
 //
 //       InputStreamResource resource = pdfService.generatePDF(data);
 //       if(resource !=null){
 //           return ResponseEntity.ok().body(resource);
 //       }else{
 //           return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
 //       }
 //   }

    

}
