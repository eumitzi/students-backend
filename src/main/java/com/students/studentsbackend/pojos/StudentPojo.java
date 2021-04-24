package com.students.studentsbackend.pojos;

public class StudentPojo {
    private int id_student;
    private String nr_matricol;
    private int id_persoana;

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
}
