package com.students.studentsbackend.pojos;

import java.util.Objects;

public class StudentPojo {
    private int id_student;
    private String nr_matricol;

    public StudentPojo(){

    }

    public StudentPojo(int id_student, String nr_matricol, int id_persoana) {
        this.id_student = id_student;
        this.nr_matricol = nr_matricol;
        this.id_persoana = id_persoana;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getNr_matricol() {
        return nr_matricol;
    }

    public void setNr_matricol(String nr_matricol) {
        this.nr_matricol = nr_matricol;
    }

    public int getId_persoana() {
        return id_persoana;
    }

    public void setId_persoana(int id_persoana) {
        this.id_persoana = id_persoana;
    }

    private int id_persoana;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentPojo that = (StudentPojo) o;
        return id_student == that.id_student &&
                id_persoana == that.id_persoana &&
                nr_matricol.equals(that.nr_matricol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_student, nr_matricol, id_persoana);
    }
}
