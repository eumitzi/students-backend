package com.students.studentsbackend.pojos;

import java.util.Objects;

public class InstantaDisciplinaPojo {

  private int id_instanta_disciplina;
  private int id_disciplina;
  private int id_an_studiu;
  private int id_an_universitar;
  private int numar_credite;
  private int semestru;
  private int id_student;
  private double factor_k;

  public int getId_profesor() {
    return id_profesor;
  }

  public void setId_profesor(int id_profesor) {
    this.id_profesor = id_profesor;
  }

  private int id_profesor;

  public InstantaDisciplinaPojo() {}

  public int getId_an_studiu() {
    return id_an_studiu;
  }

  public void setId_an_studiu(int id_an_studiu) {
    this.id_an_studiu = id_an_studiu;
  }

  public int getId_instanta_disciplina() {
    return id_instanta_disciplina;
  }

  public void setId_instanta_disciplina(int id_instanta_disciplina) {
    this.id_instanta_disciplina = id_instanta_disciplina;
  }

  public int getId_disciplina() {
    return id_disciplina;
  }

  public void setId_disciplina(int id_disciplina) {
    this.id_disciplina = id_disciplina;
  }

  public int getId_an_universitar() {
    return id_an_universitar;
  }

  @Override
  public String toString() {
    return "InstantaDisciplinaPojo{" +
            "id_instanta_disciplina=" + id_instanta_disciplina +
            ", id_disciplina=" + id_disciplina +
            ", id_an_studiu=" + id_an_studiu +
            ", id_an_universitar=" + id_an_universitar +
            ", numar_credite=" + numar_credite +
            ", semestru=" + semestru +
            ", id_student=" + id_student +
            ", factor_k=" + factor_k +
            ", id_profesor=" + id_profesor +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof InstantaDisciplinaPojo)) return false;
    InstantaDisciplinaPojo that = (InstantaDisciplinaPojo) o;
    return getId_instanta_disciplina() == that.getId_instanta_disciplina() &&
            getId_disciplina() == that.getId_disciplina() &&
            getId_an_studiu() == that.getId_an_studiu() &&
            getId_an_universitar() == that.getId_an_universitar() &&
            getNumar_credite() == that.getNumar_credite() &&
            getSemestru() == that.getSemestru() &&
            getId_student() == that.getId_student() &&
            Double.compare(that.getFactor_k(), getFactor_k()) == 0 &&
            getId_profesor() == that.getId_profesor();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId_instanta_disciplina(), getId_disciplina(), getId_an_studiu(), getId_an_universitar(), getNumar_credite(), getSemestru(), getId_student(), getFactor_k(), getId_profesor());
  }

  public InstantaDisciplinaPojo(int id_instanta_disciplina, int id_disciplina, int id_an_studiu, int id_an_universitar, int numar_credite, int semestru, int id_student, double factor_k, int id_profesor) {
    this.id_instanta_disciplina = id_instanta_disciplina;
    this.id_disciplina = id_disciplina;
    this.id_an_studiu = id_an_studiu;
    this.id_an_universitar = id_an_universitar;
    this.numar_credite = numar_credite;
    this.semestru = semestru;
    this.id_student = id_student;
    this.factor_k = factor_k;
    this.id_profesor = id_profesor;
  }

  public void setId_an_universitar(int id_an_universitar) {
    this.id_an_universitar = id_an_universitar;
  }

  public int getNumar_credite() {
    return numar_credite;
  }

  public void setNumar_credite(int numar_credite) {
    this.numar_credite = numar_credite;
  }

  public int getSemestru() {
    return semestru;
  }

  public void setSemestru(int semestru) {
    this.semestru = semestru;
  }

  public int getId_student() {
    return id_student;
  }

  public void setId_student(int id_student) {
    this.id_student = id_student;
  }

  public double getFactor_k() {
    return factor_k;
  }

  public void setFactor_k(double factor_k) {
    this.factor_k = factor_k;
  }

}
