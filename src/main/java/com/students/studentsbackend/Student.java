package com.students.studentsbackend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = ",",skipFirstLine=true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @DataField(pos = 1)
    private String id;

    @DataField(pos = 2)
    private String prenume;

    @DataField(pos = 3)
    private String nume;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", prenume='" + prenume + '\'' +
                ", nume='" + nume + '\'' +
                '}';
    }
}
