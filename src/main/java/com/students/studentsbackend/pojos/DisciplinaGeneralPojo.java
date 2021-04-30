package com.students.studentsbackend.pojos;

import java.util.Objects;

public class DisciplinaGeneralPojo {

    private int id_disciplina;
    private String nume;

    public DisciplinaGeneralPojo(){

    }

    public DisciplinaGeneralPojo(int id_disciplina, String nume) {
        this.id_disciplina = id_disciplina;
        this.nume = nume;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplinaGeneralPojo that = (DisciplinaGeneralPojo) o;
        return id_disciplina == that.id_disciplina &&
                nume.equals(that.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_disciplina, nume);
    }
}
