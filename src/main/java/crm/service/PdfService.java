package crm.service;

import crm.entity.Pdf;

public interface PdfService {

    Pdf findByName(String name);

    void savePdf(Pdf pdf);

}
