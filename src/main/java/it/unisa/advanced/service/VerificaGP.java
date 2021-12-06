package it.unisa.advanced.service;

import it.unisa.advanced.dao.GreenPassDAO;
import it.unisa.advanced.dao.GreenPassDTO;
import it.unisa.advanced.dao.ScanDAO;
import it.unisa.advanced.dao.ScanDTO;
import it.unisa.advanced.domain.GreenPass;
import it.unisa.advanced.domain.Scan;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class VerificaGP {

    private GreenPassDAO greenPassDAO;
    private ScanDAO scanDAO;

    public VerificaGP(GreenPassDAO greenPassDAO, ScanDAO scanDAO) {
        this.greenPassDAO = greenPassDAO;
        this.scanDAO = scanDAO;
    }

    public Scan verifica(String qrCode) {
        GreenPassDTO gp = greenPassDAO.getByQrCode(qrCode);
        GreenPass greenPass = new GreenPass(gp.getQrCode(), gp.getNomeCompleto(), gp.getDataEmissione(), gp.getMotivazione());
        LocalDateTime today = LocalDateTime.now();
        boolean valid = greenPass.isValid(today);
        return new Scan(greenPass, today, valid);
    }

    public int numeroViolazioni() {
        List<ScanDTO> scans = scanDAO.getAll();
        List<ScanDTO> validScans = scans.stream().filter(s -> !s.isValido()).collect(Collectors.toList());
        return validScans.size();
    }
}
