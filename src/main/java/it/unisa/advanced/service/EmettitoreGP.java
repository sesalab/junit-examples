package it.unisa.advanced.service;

import it.unisa.advanced.domain.GreenPass;
import it.unisa.advanced.domain.Motivazione;

import java.time.LocalDateTime;

public class EmettitoreGP {

    public GreenPass emettiPerVaccino(String nomeCompleto, LocalDateTime data) {
        return new GreenPass(nomeCompleto, data, Motivazione.VACCINO);
    }

    public GreenPass emettiPerGuarigione(String nomeCompleto, LocalDateTime data) {
        return new GreenPass(nomeCompleto, data, Motivazione.GUARIGIONE);
    }

    public GreenPass emettiPerTampone(String nomeCompleto, LocalDateTime data) {
        return new GreenPass(nomeCompleto, data, Motivazione.TAMPONE);
    }
}
