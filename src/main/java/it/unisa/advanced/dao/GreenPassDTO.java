package it.unisa.advanced.dao;

import it.unisa.advanced.domain.Motivazione;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GreenPassDTO implements Serializable {

    private String qrCode;
    private String nomeCompleto;
    private LocalDateTime dataEmissione;
    private Motivazione motivazione;

    public GreenPassDTO() {
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDateTime getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDateTime dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public Motivazione getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(Motivazione motivazione) {
        this.motivazione = motivazione;
    }
}
