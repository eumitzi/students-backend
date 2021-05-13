package com.students.studentsbackend.pojos;

import java.util.Objects;

public class ProgramaStudiuPojo {

    private int id_prg_studiu;
    private String detaliu;

    public ProgramaStudiuPojo(){

    }

    public ProgramaStudiuPojo(int id_prg_studiu, String detaliu) {
        this.id_prg_studiu = id_prg_studiu;
        this.detaliu = detaliu;
    }

    @Override
    public String toString() {
        return "ProgramaStudiuPojo{" +
                "id_prg_studiu=" + id_prg_studiu +
                ", detaliu='" + detaliu + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramaStudiuPojo that = (ProgramaStudiuPojo) o;
        return id_prg_studiu == that.id_prg_studiu &&
                detaliu.equals(that.detaliu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_prg_studiu, detaliu);
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
