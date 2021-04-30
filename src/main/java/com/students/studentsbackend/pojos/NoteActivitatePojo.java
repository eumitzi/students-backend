package com.students.studentsbackend.pojos;

public class NoteActivitatePojo {
    private int id_nota_activitate;
    private int id_nota;
    private String data;
    private int id_student;
    private int id_instanta_disciplina;
    private float nota;

    public NoteActivitatePojo(int id_nota_activitate, int id_nota, String data, int id_student, int id_instanta_disciplina, float nota) {
        this.id_nota_activitate = id_nota_activitate;
        this.id_nota = id_nota;
        this.data = data;
        this.id_student = id_student;
        this.id_instanta_disciplina = id_instanta_disciplina;
        this.nota = nota;
    }

    public int getId_nota_activitate() {
        return id_nota_activitate;
    }

    public void setId_nota_activitate(int id_nota_activitate) {
        this.id_nota_activitate = id_nota_activitate;
    }

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getId_instanta_disciplina() {
        return id_instanta_disciplina;
    }

    public void setId_instanta_disciplina(int id_instanta_disciplina) {
        this.id_instanta_disciplina = id_instanta_disciplina;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
