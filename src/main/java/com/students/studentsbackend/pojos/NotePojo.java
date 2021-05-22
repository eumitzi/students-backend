package com.students.studentsbackend.pojos;

import java.util.Objects;

public class NotePojo {
    private int id_nota;
    private String tip_nota;

    public NotePojo(int id_nota, String tip_nota) {
        this.id_nota = id_nota;
        this.tip_nota = tip_nota;
    }

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public String getTip_nota() {
        return tip_nota;
    }

    public void setTip_nota(String tip_nota) {
        this.tip_nota = tip_nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotePojo)) return false;
        NotePojo notePojo = (NotePojo) o;
        return getId_nota() == notePojo.getId_nota() &&
                getTip_nota().equals(notePojo.getTip_nota());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_nota(), getTip_nota());
    }

    @Override
    public String toString() {
        return "NotePojo{" +
                "id_nota=" + id_nota +
                ", tip_nota='" + tip_nota + '\'' +
                '}';
    }
}
