package it.unisa.advanced.dao;

import java.time.LocalDateTime;

public class ScanDTO {
    private GreenPassDTO greenPass;
    private LocalDateTime dataVerifica;
    private boolean valido;

    public ScanDTO() {
    }

    public GreenPassDTO getGreenPass() {
        return greenPass;
    }

    public void setGreenPass(GreenPassDTO greenPass) {
        this.greenPass = greenPass;
    }

    public LocalDateTime getDataVerifica() {
        return dataVerifica;
    }

    public void setDataVerifica(LocalDateTime dataVerifica) {
        this.dataVerifica = dataVerifica;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
}
