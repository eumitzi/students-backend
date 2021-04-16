package com.students.studentsbackend.domain;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = ",",skipFirstLine=true)
public class PrimulCSV {

    @DataField(pos = 1)
    private int id_an_studiu;

    @DataField(pos = 2)
    private int an_studiu;

    @DataField(pos = 3)
    private int id_ciclu_studiu;

    @DataField(pos = 4)
    private String data_inceput;

    @DataField(pos = 5)
    private String data_sfarsit;

    @DataField(pos = 6)
    private int id_an_universitar;

    @DataField(pos = 7)
    private int an_universitar;

    @DataField(pos = 8)
    private String tip_an_universitar;

    @DataField(pos = 9)
    private String tip_ciclu_studiu;

    public int getId_an_studiu() {
        return id_an_studiu;
    }

    public void setId_an_studiu(int id_an_studiu) {
        this.id_an_studiu = id_an_studiu;
    }

    public int getAn_studiu() {
        return an_studiu;
    }

    public void setAn_studiu(int an_studiu) {
        this.an_studiu = an_studiu;
    }

    public int getId_ciclu_studiu() {
        return id_ciclu_studiu;
    }

    public void setId_ciclu_studiu(int id_ciclu_studiu) {
        this.id_ciclu_studiu = id_ciclu_studiu;
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

    public String getTip_ciclu_studiu() {
        return tip_ciclu_studiu;
    }

    public void setTip_ciclu_studiu(String tip_ciclu_studiu) {
        this.tip_ciclu_studiu = tip_ciclu_studiu;
    }
}
