package com.students.studentsbackend.pojos;

import java.util.Objects;

public class InstantaDisciplinaPojo {

    private int id_instanta_disciplina;
    private int id_disciplina;
    private int id_profesor;
    private int id_an_universitar;
    private int nr_credite;
    private int semestru;

    public InstantaDisciplinaPojo(){

    }

    public InstantaDisciplinaPojo(int id_instanta_disciplina, int id_disciplina, int id_profesor, int id_an_universitar, int nr_credite, int semestru) {
        this.id_instanta_disciplina = id_instanta_disciplina;
        this.id_disciplina = id_disciplina;
        this.id_profesor = id_profesor;
        this.id_an_universitar = id_an_universitar;
        this.nr_credite = nr_credite;
        this.semestru = semestru;
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

    public int getNr_credite() {
        return nr_credite;
    }

    public void setNr_credite(int nr_credite) {
        this.nr_credite = nr_credite;
    }

    public int getSemestru() {
        return semestru;
    }

    public void setSemestru(int semestru) {
        this.semestru = semestru;
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
                nr_credite == that.nr_credite &&
                semestru == that.semestru;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_instanta_disciplina, id_disciplina, id_profesor, id_an_universitar, nr_credite, semestru);
    }
}
