package com.flightreservation.app.util;

import com.flightreservation.app.dto.ReservationData;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class PDFGenerator {

    public void generatePdF(ReservationData reservationData, String filePath) {

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(generatedPdfTable(reservationData));
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PdfPTable generatedPdfTable(ReservationData reservationData) {

        PdfPTable pdfPTable = new PdfPTable(2);

        PdfPCell cell;

        cell = new PdfPCell(new Phrase("Flight Itinerary"));
        cell.setColspan(2);
        pdfPTable.addCell(cell);

        cell = new PdfPCell(new Phrase("Flight Details"));
        cell.setColspan(2);
        pdfPTable.addCell(cell);

        pdfPTable.addCell("Flight Number");
        pdfPTable.addCell(reservationData.getFlightDetails().getFlightNumber());

        pdfPTable.addCell("Flight OperatingAirLines");
        pdfPTable.addCell(reservationData.getFlightDetails().getOperatingAirlines());

        pdfPTable.addCell("Arrival City");
        pdfPTable.addCell(reservationData.getFlightDetails().getArrivalCity());

        pdfPTable.addCell("Departure City");
        pdfPTable.addCell(reservationData.getFlightDetails().getDepartureCity());

        pdfPTable.addCell("Departure Date");
        pdfPTable.addCell(reservationData.getFlightDetails().getDateOfDepartment().toString());

        cell = new PdfPCell(new Phrase("Passenger Details"));
        cell.setColspan(2);
        pdfPTable.addCell(cell);

        pdfPTable.addCell("Passenger Id ");
        pdfPTable.addCell(String.valueOf(reservationData.getPassengerDetails().getId()));

        pdfPTable.addCell("Passenger Name ");
        pdfPTable.addCell(reservationData.getPassengerDetails().getFirstName() + " " + reservationData.getPassengerDetails().getLastName());

        pdfPTable.addCell("Passenger Email ");
        pdfPTable.addCell(reservationData.getPassengerDetails().getEmail());

        pdfPTable.addCell("Passenger Phone ");
        pdfPTable.addCell(reservationData.getPassengerDetails().getPhone());

        return pdfPTable;
    }


}
