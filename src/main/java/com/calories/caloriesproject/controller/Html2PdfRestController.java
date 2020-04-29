package com.calories.caloriesproject.controller;

import com.calories.caloriesproject.persistence.Food;
import com.calories.caloriesproject.service.Html2PdfService;
import com.calories.caloriesproject.service.Html2PdfServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;


@Controller
//@RequiredArgsConstructor
public class Html2PdfRestController {

    //private final Html2PdfService pdfService;
    @Autowired
    private Html2PdfService html2PdfService;


    private ServletContext context;


    @GetMapping("/html2pdf")
    public void html2pdf(HttpServletRequest request, HttpServletResponse response){
        List<Food> foods = html2PdfService.getAllFood();
        boolean isFlag = html2PdfService.createPdf(foods, context, request, response);
        if(isFlag){
            String fullPath=request.getServletContext().getRealPath("/resources/reports/"+"foods"+".pdf");
            filedownload(fullPath,response,"foods.pdf");
        }
    }

    private void filedownload(String fullPath, HttpServletResponse response, String string){
        File file = new File(fullPath);
        final int BUFFER_SIZE =4096;
        if(file.exists()){
            try{
                FileInputStream inputStream = new FileInputStream(file);
                String mimeType = context.getMimeType(fullPath);
                response.setContentType(mimeType);
                response.setHeader("content-disposition","attachement; filename="+file);
                OutputStream outputStream = response.getOutputStream();
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                while((bytesRead =inputStream.read(buffer))!= -1){
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();
                file.delete();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }








 //   @PostMapping("/html2pdf")
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
