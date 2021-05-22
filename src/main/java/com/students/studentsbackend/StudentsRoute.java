package com.students.studentsbackend;

import com.students.studentsbackend.config.StudentsConfig;
import com.students.studentsbackend.domain.*;
import com.students.studentsbackend.processor.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class StudentsRoute extends RouteBuilder {

  private final InsertPrimulCsvProcessor insertPrimulCsvProcessor;
  private StudentsConfig studentsConfig;
  private final InsertAlTreileaCsvProcessor insertAlTreileaCsvProcessor;
  private final InsertIntoPerioadaSemestruProcessor insertIntoPerioadaSemestruProcessor;
  private final InsertIntoInstantaDisciplinaCsvProcessor insertIntoInstantaDisciplinaCsvProcessor;
  private final InsertStudentProfesorProcessor insertStudentProfesorProcessor;
  private final InsertIntoNotaProcessor insertIntoNotaProcessor;

  private static final DataFormat bindyCsv2 = new BindyCsvDataFormat(AlDoileaCsv.class);
  private static final DataFormat bindyCsv3 = new BindyCsvDataFormat(AlTreileaCSV.class);
  private static final DataFormat bindy = new BindyCsvDataFormat(PrimulCSV.class);
  private static final DataFormat notaCsvBindy = new BindyCsvDataFormat(NotaCSV.class);
  private static final DataFormat perioadaSemestruBindy =
      new BindyCsvDataFormat(PerioadaSemestruCsv.class);
  private static final DataFormat instantaDisciplinaBindy =
      new BindyCsvDataFormat(InstantaDisciplinaCsv.class);
  private static final DataFormat studentProfesorBindy =
      new BindyCsvDataFormat(StudentProfesorCSV.class);

  public StudentsRoute(
      InsertPrimulCsvProcessor insertPrimulCsvProcessor,
      InsertIntoNotaProcessor insertIntoNotaProcessor,
      InsertAlTreileaCsvProcessor insertAlTreileaCsvProcessor,
      InsertIntoPerioadaSemestruProcessor insertIntoPerioadaSemestruProcessor,
      InsertIntoInstantaDisciplinaCsvProcessor insertIntoInstantaDisciplinaCsvProcessor,
      InsertStudentProfesorProcessor insertStudentProfesorProcessor,
      StudentsConfig studentsConfig) {
    this.insertPrimulCsvProcessor = insertPrimulCsvProcessor;
    this.insertIntoNotaProcessor = insertIntoNotaProcessor;
    this.insertAlTreileaCsvProcessor = insertAlTreileaCsvProcessor;
    this.insertIntoPerioadaSemestruProcessor = insertIntoPerioadaSemestruProcessor;
    this.insertIntoInstantaDisciplinaCsvProcessor = insertIntoInstantaDisciplinaCsvProcessor;
    this.insertStudentProfesorProcessor = insertStudentProfesorProcessor;
    this.studentsConfig = studentsConfig;
  }

  @Override
  public void configure() throws Exception {

    String sourceUriPrimulCsv =
        MessageFormat.format(
            "file:{0}?fileName={1}&noop=true",
            studentsConfig.getSourceDirectory(), studentsConfig.getFileName());
    String sourceUriNotaCsv =
        MessageFormat.format(
            "file:{0}?fileName={1}&noop=true",
            studentsConfig.getSourceDirectory(), studentsConfig.getNoteCsv());
    String sourceUriAlTreileaCsv =
        MessageFormat.format(
            "file:{0}?fileName={1}&noop=true",
            studentsConfig.getSourceDirectory(), studentsConfig.getFileNameCSV3());

    String sourceUriPerioadaSemestruCsv =
        MessageFormat.format(
            "file:{0}?fileName={1}&noop=true&initialDelay=30000",
            studentsConfig.getSourceDirectory(), studentsConfig.getPerioadaSemestruCsv());

    String sourceUriInstantaDisciplinaCSV =
        MessageFormat.format(
            "file:{0}?fileName={1}&noop=true&initialDelay=100000",
            studentsConfig.getSourceDirectory(), studentsConfig.getInstantaDisciplinaCsv());

    String sourceUriStudentProfesorCsv =
        MessageFormat.format(
            "file:{0}?fileName={1}&noop=true&initialDelay=60000",
            studentsConfig.getSourceDirectory(), studentsConfig.getStudentProfesorCsv());

    from(sourceUriNotaCsv)
        .unmarshal(notaCsvBindy)
        .process(insertIntoNotaProcessor)
        .to("log:Informatiile despre note au fost inserate cu succes!")
        .end();

    from(sourceUriPrimulCsv)
        .unmarshal(bindy)
        .process(insertPrimulCsvProcessor)
        .to("log:Informatiile despre anul de studiu au fost inserate cu succes!")
        .end();

    from(sourceUriAlTreileaCsv)
        .unmarshal(bindyCsv3)
        .process(insertAlTreileaCsvProcessor)
        .to("log:Informatiile despre persoane si disc au fost inserate cu succes!")
        .end();

    from(sourceUriPerioadaSemestruCsv)
        .unmarshal(perioadaSemestruBindy)
        .process(insertIntoPerioadaSemestruProcessor)
        .to("log:Informatiile despre perioada studiu inserate cu succes!")
        .end();

    from(sourceUriStudentProfesorCsv)
        .unmarshal(studentProfesorBindy)
        .process(insertStudentProfesorProcessor)
        .to("log:Informatiile despre studenti si profesor inserate cu succes!")
        .end();

    from(sourceUriInstantaDisciplinaCSV)
        .unmarshal(instantaDisciplinaBindy)
        .process(insertIntoInstantaDisciplinaCsvProcessor)
        .to("log:Informatiile despre INSTANTA DISCIPLINA inserate cu succes!")
        .end();
  }
}
