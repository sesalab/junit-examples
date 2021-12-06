package it.unisa.advanced.domain;

import java.time.LocalDateTime;

public class Scan {
    private GreenPass greenPass;
    private LocalDateTime dataVerifica;
    private boolean valido;

    public Scan(GreenPass greenPass, LocalDateTime dataVerifica, boolean valido) {
        this.greenPass = greenPass;
        this.dataVerifica = dataVerifica;
        this.valido = valido;
    }

    public GreenPass getGreenPass() {
        return greenPass;
    }

    public LocalDateTime getDataVerifica() {
        return dataVerifica;
    }

    public boolean isValido() {
        return valido;
    }
}
