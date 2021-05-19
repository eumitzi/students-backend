package com.students.studentsbackend.pojos;

import java.util.Objects;

public class PerioadaSemestruPojo {

    private int id_perioada_semestru;
    private int numar_semestru;
    private int id_an_studiu;
    private String data_inceput;
    private String data_sfarsit;

    public PerioadaSemestruPojo(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PerioadaSemestruPojo)) return false;
        PerioadaSemestruPojo that = (PerioadaSemestruPojo) o;
        return getId_perioada_semestru() == that.getId_perioada_semestru() &&
                getNumar_semestru() == that.getNumar_semestru() &&
                getId_an_studiu() == that.getId_an_studiu() &&
                getData_inceput().equals(that.getData_inceput()) &&
                getData_sfarsit().equals(that.getData_sfarsit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_perioada_semestru(), getNumar_semestru(), getId_an_studiu(), getData_inceput(), getData_sfarsit());
    }

    public PerioadaSemestruPojo(int id_perioada_semestru, int numar_semestru, int id_an_studiu, String data_inceput, String data_sfarsit) {
        this.id_perioada_semestru = id_perioada_semestru;
        this.numar_semestru = numar_semestru;
        this.id_an_studiu = id_an_studiu;
        this.data_inceput = data_inceput;
        this.data_sfarsit = data_sfarsit;
    }

    public int getId_perioada_semestru() {
        return id_perioada_semestru;
    }

    public void setId_perioada_semestru(int id_perioada_semestru) {
        this.id_perioada_semestru = id_perioada_semestru;
    }

    public int getNumar_semestru() {
        return numar_semestru;
    }

    public void setNumar_semestru(int numar_semestru) {
        this.numar_semestru = numar_semestru;
    }

    public String getData_inceput() {
        return data_inceput;
    }

    public void setData_inceput(String data_inceput) {
        this.data_inceput = data_inceput;
    }

    public String getData_sfarsit() {
        return data_sfarsit;
    }

    public void setData_sfarsit(String data_sfarsit) {
        this.data_sfarsit = data_sfarsit;
    }

    public int getId_an_studiu() {
        return id_an_studiu;
    }

    public void setId_an_studiu(int id_an_studiu) {
        this.id_an_studiu = id_an_studiu;
    }
}
