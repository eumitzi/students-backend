package com.students.studentsbackend.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",",skipFirstLine=true)
public class StudentProfesorCSV {

    @DataField(pos = 1)
    private int id_profesori;

    @DataField(pos = 2)
    private int id_persoana;

    @DataField(pos = 3)
    private int id_student;

    @DataField(pos = 4)
    private String nr_matricol;

    @DataField(pos = 5)
    private int id_persoana_stud;

    public int getId_profesori() {
        return id_profesori;
    }

    public void setId_profesori(int id_profesori) {
        this.id_profesori = id_profesori;
    }

    public int getId_persoana() {
        return id_persoana;
    }

    public void setId_persoana(int id_persoana) {
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

    public int getId_persoana_stud() {
        return id_persoana_stud;
    }

    public void setId_persoana_stud(int id_persoana_stud) {
        this.id_persoana_stud = id_persoana_stud;
    }
}
