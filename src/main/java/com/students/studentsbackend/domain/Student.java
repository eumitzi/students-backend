package com.students.studentsbackend.domain;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = ",",skipFirstLine=true)
public class Student {

    @DataField(pos = 1)
    private int id;

    @DataField(pos = 2)
    private String prenume;

    @DataField(pos = 3)
    private int varsta;

//    public Student(int id, String prenume, int varsta) {
//        this.id = id;
//        this.prenume = prenume;
//        this.varsta = varsta;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
