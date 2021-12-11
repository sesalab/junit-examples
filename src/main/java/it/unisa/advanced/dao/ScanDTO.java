package it.unisa.advanced.dao;

import java.time.LocalDateTime;
import java.util.Objects;

public class ScanDTO {
    private String greenPass;
    private LocalDateTime dataVerifica;
    private boolean valido;

    public ScanDTO() {
    }

    public String getGreenPass() {
        return greenPass;
    }

    public void setGreenPass(String greenPass) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScanDTO scanDTO = (ScanDTO) o;
        return valido == scanDTO.valido && Objects.equals(greenPass, scanDTO.greenPass) && Objects.equals(dataVerifica, scanDTO.dataVerifica);
    }
}
