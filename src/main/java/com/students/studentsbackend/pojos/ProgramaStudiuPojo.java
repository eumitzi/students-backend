package com.students.studentsbackend.pojos;

import java.util.Objects;

public class ProgramaStudiuPojo {

    private int id_prg_studiu;
    private String detaliu;

    public int getId_ciclu_studiu() {
        return id_ciclu_studiu;
    }

    public void setId_ciclu_studiu(int id_ciclu_studiu) {
        this.id_ciclu_studiu = id_ciclu_studiu;
    }

    private int id_ciclu_studiu;

    public ProgramaStudiuPojo(){

    }

    public ProgramaStudiuPojo(int id_prg_studiu, String detaliu, int id_ciclu_studiu) {
        this.id_prg_studiu = id_prg_studiu;
        this.detaliu = detaliu;
        this.id_ciclu_studiu = id_ciclu_studiu;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProgramaStudiuPojo)) return false;
        ProgramaStudiuPojo that = (ProgramaStudiuPojo) o;
        return getId_prg_studiu() == that.getId_prg_studiu() &&
                getId_ciclu_studiu() == that.getId_ciclu_studiu() &&
                getDetaliu().equals(that.getDetaliu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_prg_studiu(), getDetaliu(), getId_ciclu_studiu());
    }

    public int getId_prg_studiu() {
        return id_prg_studiu;
    }

    public void setId_prg_studiu(int id_prg_studiu) {
        this.id_prg_studiu = id_prg_studiu;
    }

    public String getDetaliu() {
        return detaliu;
    }

    public void setDetaliu(String detaliu) {
        this.detaliu = detaliu;
    }
}
