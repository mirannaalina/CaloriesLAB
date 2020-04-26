package com.calories.caloriesproject.service;

import com.itextpdf.html2pdf.HtmlConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;

@Service
@RequiredArgsConstructor
@Log
public class Html2PdfServiceImpl implements Html2PdfService{

    //https://www.youtube.com/watch?v=nahkuhuEQXg

    //https://www.youtube.com/watch?v=0RdfQHI29mE

    private final TemplateEngine templateEngine;

    @Override
    public InputStreamResource generatePDF(Map<String, Object> data){
        Context context = new Context();
        context.setVariables(data);
        String html = templateEngine.process("date",context);
        log.info(html);

        try {
            HtmlConverter.convertToPdf(html, new FileOutputStream("target/test.pdf"));
            return new InputStreamResource(new FileInputStream("target/test.pdf"));
        }catch (IOException e){
            log.log(Level.SEVERE,e.getMessage(),e );
        }
        return null;
    }

}
