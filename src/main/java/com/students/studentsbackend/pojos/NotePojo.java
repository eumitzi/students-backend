package com.students.studentsbackend.pojos;

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
}
