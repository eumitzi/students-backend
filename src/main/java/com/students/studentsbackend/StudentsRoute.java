package com.students.studentsbackend;

import com.students.studentsbackend.config.StudentsConfig;
import com.students.studentsbackend.domain.*;
import com.students.studentsbackend.processor.*;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class StudentsRoute extends RouteBuilder {

  private InsertPrimulCsvProcessor insertPrimulCsvProcessor;
  private StudentsConfig studentsConfig;
  private InsertAlDoileaCsvProcessor insertAlDoileaCsvProcessor;
  private InsertAlTreileaCsvProcessor insertAlTreileaCsvProcessor;
  private InsertIntoPerioadaSemestruProcessor insertIntoPerioadaSemestruProcessor;
  private InsertIntoInstantaDisciplinaCsvProcessor insertIntoInstantaDisciplinaCsvProcessor;
  private static final DataFormat bindyCsv2 = new BindyCsvDataFormat(AlDoileaCsv.class);
  private static final DataFormat bindyCsv3 = new BindyCsvDataFormat(AlTreileaCSV.class);
  private static final DataFormat bindy = new BindyCsvDataFormat(PrimulCSV.class);
  private static final DataFormat perioadaSemestruBindy =
      new BindyCsvDataFormat(PerioadaSemestruCsv.class);
  private static final DataFormat instantaDisciplinaBindy =
          new BindyCsvDataFormat(InstantaDisciplinaCsv.class);

  public StudentsRoute(
      InsertPrimulCsvProcessor insertPrimulCsvProcessor,
      InsertAlDoileaCsvProcessor insertAlDoileaCsvProcessor,
      InsertAlTreileaCsvProcessor insertAlTreileaCsvProcessor,
      InsertIntoPerioadaSemestruProcessor insertIntoPerioadaSemestruProcessor,
      InsertIntoInstantaDisciplinaCsvProcessor insertIntoInstantaDisciplinaCsvProcessor,
      StudentsConfig studentsConfig) {
    this.insertPrimulCsvProcessor = insertPrimulCsvProcessor;
    this.insertAlDoileaCsvProcessor = insertAlDoileaCsvProcessor;
    this.insertAlTreileaCsvProcessor = insertAlTreileaCsvProcessor;
    this.insertIntoPerioadaSemestruProcessor = insertIntoPerioadaSemestruProcessor;
    this.insertIntoInstantaDisciplinaCsvProcessor = insertIntoInstantaDisciplinaCsvProcessor;
    this.studentsConfig = studentsConfig;
  }

  @Override
  public void configure() throws Exception {

    String sourceUriPrimulCsv =
        MessageFormat.format(
            "file:{0}?fileName={1}&noop=true",
            studentsConfig.getSourceDirectory(), studentsConfig.getFileName());
    String sourceUriAlDoileaCsv =
        MessageFormat.format(
            "file:{0}?fileName={1}&noop=true",
            studentsConfig.getSourceDirectory(), studentsConfig.getFileNameCsv2());
    String sourceUriAlTreileaCsv =
        MessageFormat.format(
            "file:{0}?fileName={1}&noop=true",
            studentsConfig.getSourceDirectory(), studentsConfig.getFileNameCSV3());

    String sourceUriPerioadaSemestruCsv =
        MessageFormat.format(
            "file:{0}?fileName={1}&noop=true&initialDelay=50000",
            studentsConfig.getSourceDirectory(), studentsConfig.getPerioadaSemestruCsv());

    String sourceUriInstantaDisciplinaCSV =
            MessageFormat.format(
                    "file:{0}?fileName={1}&noop=true&initialDelay=50000",
                    studentsConfig.getSourceDirectory(), studentsConfig.getInstantaDisciplinaCsv());

    from(sourceUriPrimulCsv)
        .unmarshal(bindy)
        .to("log:?level=INFO&showBody=true&showHeaders=true")
        .process(insertPrimulCsvProcessor)
        .to("log:Informatiile despre anul de studiu au fost inserate cu succes!")
        .end();

    from(sourceUriAlTreileaCsv)
        .unmarshal(bindyCsv3)
        .to("log:?level=INFO&showBody=true&showHeaders=true")
        .process(insertAlTreileaCsvProcessor)
        .to("log:Informatiile despre persoane si disc au fost inserate cu succes!")
        .end();

    from(sourceUriPerioadaSemestruCsv)
        .unmarshal(perioadaSemestruBindy)
        .to("log:?level=INFO&showBody=true&showHeaders=true")
        .process(insertIntoPerioadaSemestruProcessor)
        .to("log:Informatiile despre PERIOADA STUDIU inserate cu succes!")
        .end();

    from(sourceUriInstantaDisciplinaCSV)
            .unmarshal(instantaDisciplinaBindy)
            .to("log:?level=INFO&showBody=true&showHeaders=true")
            .process(insertIntoInstantaDisciplinaCsvProcessor)
            .to("log:Informatiile despre INSTANTA DISCIPLINA inserate cu succes!")
            .end();
  }
}
