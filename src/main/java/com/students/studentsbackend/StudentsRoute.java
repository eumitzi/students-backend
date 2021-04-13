package com.students.studentsbackend;

import com.students.studentsbackend.config.StudentsConfig;
import com.students.studentsbackend.domain.Student;
import com.students.studentsbackend.processor.InsertProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class StudentsRoute extends RouteBuilder {

    private InsertProcessor insertProcessor;
    private StudentsConfig studentsConfig;

    public StudentsRoute(InsertProcessor insertProcessor, StudentsConfig studentsConfig){
        this.insertProcessor = insertProcessor;
        this.studentsConfig = studentsConfig;
    }
    @Override
    public void configure() throws Exception {

    String sourceUri = MessageFormat.format("file:{0}?fileName={1}&noop=true", studentsConfig.getSourceDirectory(), studentsConfig.getFileName());

    DataFormat bindy = new BindyCsvDataFormat(Student.class);
    from(sourceUri)
        .unmarshal(bindy)
        .to("log:?level=INFO&showBody=true&showHeaders=true")
        .process(insertProcessor)
        .to("log:Successfully inserted into the database");
    }
}
