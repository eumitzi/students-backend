package com.students.studentsbackend.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", skipFirstLine = true)
public class PerioadaSemestruCsv {

  @DataField(pos = 1)
  private int id_perioada_semestru;

  @DataField(pos = 2)
  private int numar_semestru;

  @DataField(pos = 3)
  private int id_an_studiu;

  @DataField(pos = 4)
  private String data_inceput;

  @DataField(pos = 5)
  private String data_sfarsit;

  public int getId_perioada_semestru() {
    return id_perioada_semestru;
  }

  public void setId_perioada_semestru(int id_perioada_semestru) {
    this.id_perioada_semestru = id_perioada_semestru;
  }

  public int getId_an_studiu() {
    return id_an_studiu;
  }

  public void setId_an_studiu(int id_an_studiu) {
    this.id_an_studiu = id_an_studiu;
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

  public int getNumar_semestru() {
    return numar_semestru;
  }

  public void setNumar_semestru(int numar_semestru) {
    this.numar_semestru = numar_semestru;
  }
}
