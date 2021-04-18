package com.students.studentsbackend;

import com.students.studentsbackend.config.StudentsConfig;
import com.students.studentsbackend.domain.PrimulCSV;
import com.students.studentsbackend.processor.InsertPrimulCsvProcessor;
import com.students.studentsbackend.processor.InsertIntoAnUniversitarProcessor;
import com.students.studentsbackend.processor.InsertIntoCicluStudiuProcessor;
import com.students.studentsbackend.processor.InsertIntoProgramaStudiuProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class StudentsRoute extends RouteBuilder {

    private InsertPrimulCsvProcessor insertPrimulCsvProcessor;
    private StudentsConfig studentsConfig;
    private static final DataFormat bindy = new BindyCsvDataFormat(PrimulCSV.class);

    public StudentsRoute(InsertPrimulCsvProcessor insertPrimulCsvProcessor,
                         StudentsConfig studentsConfig) {
        this.insertPrimulCsvProcessor = insertPrimulCsvProcessor;
        this.studentsConfig = studentsConfig;
    }

    @Override
    public void configure() throws Exception {

        String sourceUriPrimulCsv = MessageFormat.format("file:{0}?fileName={1}&noop=true", studentsConfig.getSourceDirectory(), studentsConfig.getFileName());

        from(sourceUriPrimulCsv)
                .unmarshal(bindy)
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .process(insertPrimulCsvProcessor)
                .to("log:Informatiile despre anul de studiu au fost inserate cu succes!");

    }
}
