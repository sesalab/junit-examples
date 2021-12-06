package it.unisa.advanced.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class GreenPass {
    private String qrCode;
    private String nomeCompleto;
    private LocalDateTime dataEmissione;
    private Motivazione motivazione;

    public GreenPass(String qrCode, String nomeCompleto, LocalDateTime dataEmissione, Motivazione motivazione) {
        this.qrCode = qrCode;
        this.nomeCompleto = nomeCompleto;
        this.dataEmissione = dataEmissione;
        this.motivazione = motivazione;
    }

    public GreenPass(String nomeCompleto, LocalDateTime dataEmissione, Motivazione motivazione) {
        this.qrCode = UUID.randomUUID().toString();
        this.nomeCompleto = nomeCompleto;
        this.dataEmissione = dataEmissione;
        this.motivazione = motivazione;
    }

    public boolean isSuper() {
        return motivazione != Motivazione.TAMPONE;
    }

    public boolean isValid(LocalDateTime dataVerifica) {
        long mesiTrascorsi = ChronoUnit.MONTHS.between(dataEmissione, dataVerifica);
        return mesiTrascorsi < 9;
    }

}
