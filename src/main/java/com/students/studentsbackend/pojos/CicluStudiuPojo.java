package com.students.studentsbackend.pojos;

import java.util.Objects;

public class CicluStudiuPojo {

    private String tip_ciclu_studiu;
    private int id_ciclu_studiu;

    public CicluStudiuPojo(String tip_ciclu_studiu, int id_ciclu_studiu) {
        this.tip_ciclu_studiu = tip_ciclu_studiu;
        this.id_ciclu_studiu = id_ciclu_studiu;
    }

    public CicluStudiuPojo() {

    }

    public String getTip_ciclu_studiu() {
        return tip_ciclu_studiu;
    }

    public void setTip_ciclu_studiu(String tip_ciclu_studiu) {
        this.tip_ciclu_studiu = tip_ciclu_studiu;
    }

    public int getId_ciclu_studiu() {
        return id_ciclu_studiu;
    }

    public void setId_ciclu_studiu(int id_ciclu_studiu) {
        this.id_ciclu_studiu = id_ciclu_studiu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CicluStudiuPojo that = (CicluStudiuPojo) o;
        return id_ciclu_studiu == that.id_ciclu_studiu &&
                tip_ciclu_studiu.equals(that.tip_ciclu_studiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tip_ciclu_studiu, id_ciclu_studiu);
    }
}
