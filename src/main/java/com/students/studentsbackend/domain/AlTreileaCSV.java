package com.students.studentsbackend.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import java.util.Objects;

@CsvRecord( separator = ",",skipFirstLine=true)
public class AlTreileaCSV {

    @DataField(pos = 1)
    private int id_disciplina;

    @DataField(pos = 2)
    private String nume;

    @DataField(pos = 3)
    private int id_tip_persoane;

    @DataField(pos = 4)
    private String tip_persoane;

    @DataField(pos = 5)
    private int id_persoana;

    public int getId_tip_pers() {
        return id_tip_pers;
    }

    public void setId_tip_pers(int id_tip_pers) {
        this.id_tip_pers = id_tip_pers;
    }

    @DataField(pos = 6)
    private int id_tip_pers;

    @DataField(pos = 7)
    private String nume_persoana;

    @DataField(pos = 8)
    private String prenume_persoana;

    @DataField(pos = 9)
    private String adresa;

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getId_tip_persoane() {
        return id_tip_persoane;
    }

    public void setId_tip_persoane(int id_tip_persoane) {
        this.id_tip_persoane = id_tip_persoane;
    }

    public String getTip_persoane() {
        return tip_persoane;
    }

    public void setTip_persoane(String tip_persoane) {
        this.tip_persoane = tip_persoane;
    }

    public int getId_persoana() {
        return id_persoana;
    }

    public void setId_persoana(int id_persoana) {
        this.id_persoana = id_persoana;
    }

    public String getNume_persoana() {
        return nume_persoana;
    }

    public void setNume_persoana(String nume_persoana) {
        this.nume_persoana = nume_persoana;
    }

    public String getPrenume_persoana() {
        return prenume_persoana;
    }

    public void setPrenume_persoana(String prenume_persoana) {
        this.prenume_persoana = prenume_persoana;
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
        AlTreileaCSV that = (AlTreileaCSV) o;
        return id_disciplina == that.id_disciplina &&
                id_tip_persoane == that.id_tip_persoane &&
                id_persoana == that.id_persoana &&
                nume.equals(that.nume) &&
                tip_persoane.equals(that.tip_persoane) &&
                nume_persoana.equals(that.nume_persoana) &&
                prenume_persoana.equals(that.prenume_persoana) &&
                adresa.equals(that.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_disciplina, nume, id_tip_persoane, tip_persoane, id_persoana, nume_persoana, prenume_persoana, adresa);
    }
}
