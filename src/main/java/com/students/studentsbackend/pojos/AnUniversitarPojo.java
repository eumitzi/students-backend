package com.students.studentsbackend.pojos;

import java.util.Objects;

public class AnUniversitarPojo {

    private int id_an_universitar;
    private int an_universitar;
    private String tip_an_universitar;

    public AnUniversitarPojo(int id_an_universitar, int an_universitar, String tip_an_universitar) {
        this.id_an_universitar = id_an_universitar;
        this.an_universitar = an_universitar;
        this.tip_an_universitar = tip_an_universitar;
    }

    public AnUniversitarPojo(){

    }

    public int getId_an_universitar() {
        return id_an_universitar;
    }

    public void setId_an_universitar(int id_an_universitar) {
        this.id_an_universitar = id_an_universitar;
    }

    public int getAn_universitar() {
        return an_universitar;
    }

    public void setAn_universitar(int an_universitar) {
        this.an_universitar = an_universitar;
    }

    public String getTip_an_universitar() {
        return tip_an_universitar;
    }

    public void setTip_an_universitar(String tip_an_universitar) {
        this.tip_an_universitar = tip_an_universitar;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnUniversitarPojo that = (AnUniversitarPojo) o;
        return id_an_universitar == that.id_an_universitar &&
                an_universitar == that.an_universitar &&
                tip_an_universitar.equals(that.tip_an_universitar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_an_universitar, an_universitar, tip_an_universitar);
    }
}
