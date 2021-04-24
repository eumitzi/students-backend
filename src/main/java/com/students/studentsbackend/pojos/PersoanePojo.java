package com.students.studentsbackend.pojos;

import java.util.Objects;

public class PersoanePojo {
    private int id_persoana;
    private int id_tip_persoana;
    private String nume;
    private String prenume;
    private String adresa;

    public PersoanePojo(int id_persoana, int id_tip_persoana, String nume, String prenume, String adresa) {
        this.id_persoana = id_persoana;
        this.id_tip_persoana = id_tip_persoana;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
    }

    public PersoanePojo(){

    }

    public int getId_persoana() {
        return id_persoana;
    }

    public void setId_persoana(int id_persoana) {
        this.id_persoana = id_persoana;
    }

    public int getId_tip_persoana() {
        return id_tip_persoana;
    }

    public void setId_tip_persoana(int id_tip_persoana) {
        this.id_tip_persoana = id_tip_persoana;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersoanePojo that = (PersoanePojo) o;
        return id_persoana == that.id_persoana &&
                id_tip_persoana == that.id_tip_persoana &&
                nume.equals(that.nume) &&
                prenume.equals(that.prenume) &&
                adresa.equals(that.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_persoana, id_tip_persoana, nume, prenume, adresa);
    }
}


