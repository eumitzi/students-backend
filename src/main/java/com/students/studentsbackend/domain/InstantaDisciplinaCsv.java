package com.students.studentsbackend.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = ",",skipFirstLine=true)
public class InstantaDisciplinaCsv {

    @DataField(pos = 1)
    private int id_instanta_disciplina;

    @DataField(pos = 2)
    private int id_disciplina;

    @DataField(pos = 3)
    private int id_an_studiu;

    @DataField(pos = 4)
    private int id_an_universitar;

    @DataField(pos = 5)
    private int numar_credite;

    @DataField(pos = 6)
    private int semestru;

    @DataField(pos = 7)
    private int id_student;

    @DataField(pos = 8)
    private double factor_k;

    @DataField(pos = 9)
    private int id_profesor;

    public void setFactor_k(int factor_k) {
        this.factor_k = factor_k;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getId_an_studiu() {
        return id_an_studiu;
    }

    public void setId_an_studiu(int id_an_studiu) {
        this.id_an_studiu = id_an_studiu;
    }

    public int getId_instanta_disciplina() {
        return id_instanta_disciplina;
    }

    public void setId_instanta_disciplina(int id_instanta_disciplina) {
        this.id_instanta_disciplina = id_instanta_disciplina;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public int getId_an_universitar() {
        return id_an_universitar;
    }

    public void setId_an_universitar(int id_an_universitar) {
        this.id_an_universitar = id_an_universitar;
    }

    public int getNumar_credite() {
        return numar_credite;
    }

    public void setNumar_credite(int numar_credite) {
        this.numar_credite = numar_credite;
    }

    public int getSemestru() {
        return semestru;
    }

    public void setSemestru(int semestru) {
        this.semestru = semestru;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public double getFactor_k() {
        return factor_k;
    }

    public void setFactor_k(double factor_k) {
        this.factor_k = factor_k;
    }
}
