package main.resources.java.handler;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * PDForm helper for creating a base template for the form
 */
public class PDFormUtils {

    /**
     * Creates a base form for Character sheet
     *
     * @param file       location that you will be using to for file
     * @param fieldNames names of the fields for Character
     * @throws IOException catch an error
     */
    public static void createPdfA4(File file, List<String> fieldNames)
            throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4); // A4 size
            document.addPage(page);

            // Create AcroForm
            PDAcroForm acroForm = new PDAcroForm(document);
            document.getDocumentCatalog().setAcroForm(acroForm);

            // A4 page dimensions
            PDRectangle mediaBox = page.getMediaBox();
            float pageWidth = mediaBox.getWidth();
            float pageHeight = mediaBox.getHeight();

            // Field layout
            float margin = 50;             // margin from edges
            float width = pageWidth - 2 * margin;  // field width
            float height = 20;             // height of each field
            int n = fieldNames.size();
            float availableHeight = pageHeight - 2 * margin;
            float gap = n > 1 ? (availableHeight - n * height) / (n - 1) : 0;
            float y = pageHeight - margin - height;

            for (String name : fieldNames) {
                PDTextField textField = new PDTextField(acroForm);
                textField.setPartialName(name);

                // Add field to form
                acroForm.getFields().add(textField);

                // Widget to place field on page
                PDAnnotationWidget widget = new PDAnnotationWidget();
                widget.setRectangle(new PDRectangle(margin, y, width, height));
                widget.setPage(page);

                textField.setWidgets(List.of(widget));
                page.getAnnotations().add(widget);

                y -= (height + gap); // move down
            }
            document.save(file);
        }
    }
}

