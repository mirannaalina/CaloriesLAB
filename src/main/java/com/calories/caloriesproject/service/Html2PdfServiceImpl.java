package com.calories.caloriesproject.service;

import com.calories.caloriesproject.persistence.Food;
import com.calories.caloriesproject.persistence.FoodRepository;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

import static sun.plugin.javascript.navig.JSType.Document;

@Service
@RequiredArgsConstructor
@Log
public class Html2PdfServiceImpl implements Html2PdfService{
/*
    //https://www.youtube.com/watch?v=nahkuhuEQXg

    //https://www.youtube.com/watch?v=0RdfQHI29mE

    private final TemplateEngine templateEngine;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public InputStreamResource generatePDF(Map<String, Object> data){
  //      Context context = new Context();
  //      context.setVariables(data);
  //      String html = templateEngine.process("date",context);
  //      log.info(html);
  //
  //       try {
  //           HtmlConverter.convertToPdf(html, new FileOutputStream("target/test.pdf"));
  //           return new InputStreamResource(new FileInputStream("target/test.pdf"));
  //       }catch (IOException e){
  //           log.log(Level.SEVERE,e.getMessage(),e );
  //       }
          return null;
     }


    @Override
    public boolean createPdf(List<Food> foods, ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        Document document = new Document(PageSize.A4,15,15,45,30);

        try{
            String filePath = context.getRealPath("/resources/reports");
            File file = new File(filePath);
            boolean exists = new File(filePath).exists();
            if(!exists){
                new File(filePath).mkdirs();
            }
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(file+"/"+"foods"+".pdf"));
            document.open();

            Font mainFont = FontFactory.getFont("Arial",10, BaseColor.BLACK);

            Paragraph paragraph = new Paragraph("All foods", mainFont);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setIndentationLeft(50);
            paragraph.setIndentationRight(50);
            paragraph.setSpacingAfter(10);
            document.add(paragraph);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10);

            Font tableHeader = FontFactory.getFont("Arial",10,BaseColor.BLACK);
            Font tablebody = FontFactory.getFont("Arial",10,BaseColor.BLACK);

            float[] columnWidths = {2f,2f,2f,2f};
            table.setWidths(columnWidths);

            PdfPCell nume = new PdfPCell(new Paragraph("Nume",tableHeader));
            nume.setBorderColor(BaseColor.BLACK);
            nume.setPaddingLeft(10);
            nume.setHorizontalAlignment(Element.ALIGN_CENTER);
            nume.setVerticalAlignment(Element.ALIGN_CENTER);
            nume.setBackgroundColor(BaseColor.DARK_GRAY);
            nume.setExtraParagraphSpace(5f);
            table.addCell(nume);

            PdfPCell unitatedemasura = new PdfPCell(new Paragraph("Unitate de masura",tableHeader));
            unitatedemasura.setBorderColor(BaseColor.BLACK);
            unitatedemasura.setPaddingLeft(10);
            unitatedemasura.setHorizontalAlignment(Element.ALIGN_CENTER);
            unitatedemasura.setVerticalAlignment(Element.ALIGN_CENTER);
            unitatedemasura.setBackgroundColor(BaseColor.DARK_GRAY);
            unitatedemasura.setExtraParagraphSpace(5f);
            table.addCell(unitatedemasura);

            PdfPCell calorii = new PdfPCell(new Paragraph("Calorii",tableHeader));
            calorii.setBorderColor(BaseColor.BLACK);
            calorii.setPaddingLeft(10);
            calorii.setHorizontalAlignment(Element.ALIGN_CENTER);
            calorii.setVerticalAlignment(Element.ALIGN_CENTER);
            calorii.setBackgroundColor(BaseColor.DARK_GRAY);
            calorii.setExtraParagraphSpace(5f);
            table.addCell(calorii);


            for(Food food : foods ){
                PdfPCell primulnume = new PdfPCell(new Paragraph(food.getNume(),tablebody));
                primulnume.setBorderColor(BaseColor.BLACK);
                primulnume.setPaddingLeft(10);
                primulnume.setHorizontalAlignment(Element.ALIGN_CENTER);
                primulnume.setVerticalAlignment(Element.ALIGN_CENTER);
                primulnume.setBackgroundColor(BaseColor.WHITE);
                primulnume.setExtraParagraphSpace(5f);
                table.addCell(primulnume);

                PdfPCell primaunitatedemasura = new PdfPCell(new Paragraph(food.getUnitateDeMasura(),tablebody));
                primaunitatedemasura.setBorderColor(BaseColor.BLACK);
                primaunitatedemasura.setPaddingLeft(10);
                primaunitatedemasura.setHorizontalAlignment(Element.ALIGN_CENTER);
                primaunitatedemasura.setVerticalAlignment(Element.ALIGN_CENTER);
                primaunitatedemasura.setBackgroundColor(BaseColor.WHITE);
                primaunitatedemasura.setExtraParagraphSpace(5f);
                table.addCell(primaunitatedemasura);

               // PdfPCell primelecalorii = new PdfPCell(new Paragraph((food.getCalorii()),tablebody));
               // primelecalorii.setBorderColor(BaseColor.BLACK);
               // primelecalorii.setPaddingLeft(10);
               // primelecalorii.setHorizontalAlignment(Element.ALIGN_CENTER);
               // primelecalorii.setVerticalAlignment(Element.ALIGN_CENTER);
               // primelecalorii.setBackgroundColor(BaseColor.WHITE);
               // primelecalorii.setExtraParagraphSpace(5f);
               // table.addCell(primelecalorii);
            }

        }catch (Exception e){

        }
         return false;
    }*/
}
