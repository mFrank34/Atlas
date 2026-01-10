package handler;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDNonTerminalField;
import utilities.Constants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PDManager {

    /**
     * Checking the key of the PDF to match the application signature
     *
     * @param file caricature sheet location
     * @return bool if the document contains right sig
     */
    private static boolean compatibilityChecker(PDDocument file) {
        PDDocumentInformation info = file.getDocumentInformation();
        String signature = info.getCustomMetadataValue(Constants.SIGNATURE_KEY);
        return Constants.EXPECTED_SIGNATURE.equals(signature);
    }

    /**
     * Checking the fields from a PDF and converting them into a map system
     * @param fields the name of the field
     * @param data the current data set
     * @throws IOException to throw an error if something breaks you know
     */
    private static void readFields(List<PDField> fields, Map<String, String> data)
            throws IOException {
        for (PDField field : fields) {
            if (field instanceof PDNonTerminalField nonTerminal) {
                readFields(nonTerminal.getChildren(), data);
            } else {
                data.put(
                        field.getFullyQualifiedName(),
                        field.getValueAsString() != null ? field.getValueAsString() : ""
                );
            }
        }
    }

    /**
     * Writes the fields to the data file
     *
     * @param fields fields that need to be included
     * @param data   the data that is on the data
     * @throws IOException catch an error when converting
     */
    private static void writeFields(List<PDField> fields, Map<String, String> data) throws IOException {
        for (PDField field : fields) {
            if (field instanceof PDNonTerminalField nonTerminal) {
                writeFields(nonTerminal.getChildren(), data);
            } else {
                String value = data.get(field.getFullyQualifiedName());
                if (value != null) {
                    field.setValue(value);
                }
            }
        }
    }

    /**
     * Data from the PDF file that has been Read into application
     * @param file location of the file
     * @return returns data in manageable format
     * @throws IOException returns error if file breaks
     */
    public static Map<String, String> loadFromPdf(File file)
            throws IOException {
        Map<String, String> data = new HashMap<>();
        try (PDDocument document = PDDocument.load(file)) {
            PDAcroForm form = document.getDocumentCatalog().getAcroForm();
            if (form == null) {
                throw new IOException("PDF has no form fields");
            }

            if (!compatibilityChecker(document)) {
                throw new IOException("PDF has incompatible form fields");
            }

            readFields(form.getFields(), data);
        }
        return data;
    }

    /**
     * Save function to update a PDF form
     *
     * @param file location of the form
     * @param data data that is being modified
     * @throws IOException catch error with form if that was to happen
     */
    public static void saveToPdf(File file, Map<String, String> data) throws IOException {
        try (PDDocument document = PDDocument.load(file)) {
            PDAcroForm form = document.getDocumentCatalog().getAcroForm();
            if (form == null) {
                throw new IOException("PDF has no form fields");
            }
            writeFields(form.getFields(), data);
            document.save(file);
        }
    }
}
