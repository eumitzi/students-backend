package com.students.studentsbackend;

import com.students.studentsbackend.config.StudentsConfig;
import com.students.studentsbackend.domain.PrimulCSV;
import com.students.studentsbackend.processor.InsertIntoAnStudiuProcessor;
import com.students.studentsbackend.processor.InsertIntoAnUniversitarProcessor;
import com.students.studentsbackend.processor.InsertIntoCicluStudiuProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class StudentsRoute extends RouteBuilder {

    private InsertIntoAnStudiuProcessor insertIntoAnStudiuProcessor;
    private InsertIntoAnUniversitarProcessor insertIntoAnUniversitarProcessor;
    private InsertIntoCicluStudiuProcessor insertIntoCicluStudiuProcessor;
    private StudentsConfig studentsConfig;
    private static final DataFormat bindy = new BindyCsvDataFormat(PrimulCSV.class);

    public StudentsRoute(InsertIntoAnStudiuProcessor insertIntoAnStudiuProcessor,
                         InsertIntoCicluStudiuProcessor insertIntoCicluStudiuProcessor,
                         InsertIntoAnUniversitarProcessor insertIntoAnUniversitarProcessor,
                         StudentsConfig studentsConfig) {
        this.insertIntoAnStudiuProcessor = insertIntoAnStudiuProcessor;
        this.insertIntoAnUniversitarProcessor = insertIntoAnUniversitarProcessor;
        this.insertIntoCicluStudiuProcessor = insertIntoCicluStudiuProcessor;
        this.studentsConfig = studentsConfig;
    }

    @Override
    public void configure() throws Exception {

        String sourceUri = MessageFormat.format("file:{0}?fileName={1}&noop=true", studentsConfig.getSourceDirectory(), studentsConfig.getFileName());


        from(sourceUri)
                .unmarshal(bindy)
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .process(insertIntoCicluStudiuProcessor)
                .to("log:Successfully inserted into the database")
                .process(insertIntoAnUniversitarProcessor)
                .to("log:Successfully inserted into the database")
                .process(insertIntoAnStudiuProcessor)
                .to("log:Successfully inserted into the database");
    }
}
