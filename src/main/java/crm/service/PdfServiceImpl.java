package crm.service;

import crm.entity.Pdf;
import crm.repository.PdfRepository;
import org.springframework.stereotype.Service;

@Service
public class PdfServiceImpl implements PdfService {

    private PdfRepository pdfRepository;

    public PdfServiceImpl(PdfRepository pdfRepository) {
        this.pdfRepository = pdfRepository;
    }

    @Override
    public Pdf findByName(String name) {
        return pdfRepository.findByName(name);
    }

    @Override
    public void savePdf(Pdf pdf) {
        pdfRepository.save(pdf);
    }

}
