package com.students.studentsbackend.pojos;

import lombok.*;

import java.util.Objects;

public class ProfesoriPojo {
  private int id_profesori;
  private int id_persoana;

  public ProfesoriPojo() {
  }

  public ProfesoriPojo(int id_profesori, int id_persoana) {
    this.id_profesori = id_profesori;
    this.id_persoana = id_persoana;
  }

  public int getId_profesori() {
    return id_profesori;
  }

  public void setId_profesori(int id_profesori) {
    this.id_profesori = id_profesori;
  }

  public int getId_persoana() {
    return id_persoana;
  }

  public void setId_persoana(int id_persoana) {
    this.id_persoana = id_persoana;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProfesoriPojo that = (ProfesoriPojo) o;
    return id_profesori == that.id_profesori &&
            id_persoana == that.id_persoana;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id_profesori, id_persoana);
  }
}
