package com.students.studentsbackend;

import com.students.studentsbackend.domain.Student;
import com.students.studentsbackend.processor.InsertProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

@Component
public class StudentsRoute extends RouteBuilder {

    private InsertProcessor insertProcessor;

    public StudentsRoute(InsertProcessor insertProcessor){
        this.insertProcessor = insertProcessor;
    }
    @Override
    public void configure() throws Exception {
    DataFormat bindy = new BindyCsvDataFormat(Student.class);
    from("file:data/csv/input?fileName=file4.txt&noop=true")
        .unmarshal(bindy)
        .to("log:?level=INFO&showBody=true&showHeaders=true")
        .process(insertProcessor)
        .to("log:Successfully inserted into the database");
    }
}
