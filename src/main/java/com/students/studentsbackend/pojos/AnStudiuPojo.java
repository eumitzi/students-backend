package com.students.studentsbackend.pojos;

import java.util.Objects;

public class AnStudiuPojo {

    private int id_an_studiu;
    private int an_studiu;
    private String data_inceput;
    private String data_sfarsit;
    private int id_an_universitar;
    private int id_ciclu_studiu;

    public AnStudiuPojo(int id_an_studiu, int an_studiu, String data_inceput, String data_sfarsit, int id_an_universitar, int id_ciclu_studiu) {
        this.id_an_studiu = id_an_studiu;
        this.an_studiu = an_studiu;
        this.data_inceput = data_inceput;
        this.data_sfarsit = data_sfarsit;
        this.id_an_universitar = id_an_universitar;
        this.id_ciclu_studiu = id_ciclu_studiu;
    }

    public AnStudiuPojo(){

    }

    public int getId_ciclu_studiu() {
        return id_ciclu_studiu;
    }

    public void setId_ciclu_studiu(int id_ciclu_studiu) {
        this.id_ciclu_studiu = id_ciclu_studiu;
    }

    public int getId_an_studiu() {
        return id_an_studiu;
    }

    public void setId_an_studiu(int id_an_studiu) {
        this.id_an_studiu = id_an_studiu;
    }

    public int getAn_studiu() {
        return an_studiu;
    }

    public void setAn_studiu(int an_studiu) {
        this.an_studiu = an_studiu;
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

    @Override
    public String toString() {
        return "AnStudiuPojo{" +
                "id_an_studiu=" + id_an_studiu +
                ", an_studiu=" + an_studiu +
                ", data_inceput='" + data_inceput + '\'' +
                ", data_sfarsit='" + data_sfarsit + '\'' +
                ", id_an_universitar=" + id_an_universitar +
                ", id_ciclu_studiu=" + id_ciclu_studiu +
                '}';
    }

    public int getId_an_universitar() {
        return id_an_universitar;
    }


    public void setId_an_universitar(int id_an_universitar) {
        this.id_an_universitar = id_an_universitar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnStudiuPojo)) return false;
        AnStudiuPojo that = (AnStudiuPojo) o;
        return getId_an_studiu() == that.getId_an_studiu() &&
                getAn_studiu() == that.getAn_studiu() &&
                getId_an_universitar() == that.getId_an_universitar() &&
                getId_ciclu_studiu() == that.getId_ciclu_studiu() &&
                getData_inceput().equals(that.getData_inceput()) &&
                getData_sfarsit().equals(that.getData_sfarsit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_an_studiu(), getAn_studiu(), getData_inceput(), getData_sfarsit(), getId_an_universitar(), getId_ciclu_studiu());
    }
}
