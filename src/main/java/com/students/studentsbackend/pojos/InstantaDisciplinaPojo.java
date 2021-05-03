package com.students.studentsbackend.pojos;

import lombok.*;

import java.util.Objects;

public class InstantaDisciplinaPojo {

    private int id_instanta_disciplina;
    private int id_disciplina;
    private int id_profesor;
    private int id_an_universitar;
    private int numar_credite;
    private int semestru;
    private int id_student;
    private double factor_k;

    public InstantaDisciplinaPojo() {}

    public InstantaDisciplinaPojo(int id_instanta_disciplina, int id_disciplina, int id_profesor, int id_an_universitar, int numar_credite, int semestru, int id_student, double factor_k) {
        this.id_instanta_disciplina = id_instanta_disciplina;
        this.id_disciplina = id_disciplina;
        this.id_profesor = id_profesor;
        this.id_an_universitar = id_an_universitar;
        this.numar_credite = numar_credite;
        this.semestru = semestru;
        this.id_student = id_student;
        this.factor_k = factor_k;
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

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstantaDisciplinaPojo that = (InstantaDisciplinaPojo) o;
        return id_instanta_disciplina == that.id_instanta_disciplina &&
                id_disciplina == that.id_disciplina &&
                id_profesor == that.id_profesor &&
                id_an_universitar == that.id_an_universitar &&
                numar_credite == that.numar_credite &&
                semestru == that.semestru &&
                id_student == that.id_student &&
                Double.compare(that.factor_k, factor_k) == 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_instanta_disciplina, id_disciplina, id_profesor, id_an_universitar, numar_credite, semestru, id_student, factor_k);
    }
}
