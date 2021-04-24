package com.students.studentsbackend.processor;

import com.students.studentsbackend.StudentsConstants;
import com.students.studentsbackend.domain.AlDoileaCsv;
import com.students.studentsbackend.pojos.DisciplinaGeneralPojo;
import com.students.studentsbackend.pojos.InstantaDisciplinaPojo;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class InsertAlDoileaCsvProcessor implements Processor {

  private DataSource dataSource;

  public InsertAlDoileaCsvProcessor(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void process(Exchange exchange) throws Exception {

    ArrayList<AlDoileaCsv> exchangeBody = exchange.getIn().getBody(ArrayList.class);
    ArrayList<DisciplinaGeneralPojo> disciplinaGeneralPojos = new ArrayList<>();
    ArrayList<InstantaDisciplinaPojo> instantaDisciplinaPojos = new ArrayList<>();

    for (AlDoileaCsv alDoileaCsv : exchangeBody) {
      // disciplina general
      DisciplinaGeneralPojo disciplinaGeneralPojo = new DisciplinaGeneralPojo();
      disciplinaGeneralPojo.setId_disciplina(alDoileaCsv.getId_disciplina());
      disciplinaGeneralPojo.setNume(alDoileaCsv.getNume());
      disciplinaGeneralPojos.add(disciplinaGeneralPojo);

      // instanta disciplina
      InstantaDisciplinaPojo instantaDisciplinaPojo = new InstantaDisciplinaPojo();
      instantaDisciplinaPojo.setId_instanta_disciplina(alDoileaCsv.getId_instanta_disciplina());
      instantaDisciplinaPojo.setId_an_universitar(alDoileaCsv.getId_an_universitar());
      instantaDisciplinaPojo.setId_disciplina(alDoileaCsv.getId_disciplina());
      instantaDisciplinaPojo.setId_profesor(alDoileaCsv.getId_profesor());
      instantaDisciplinaPojo.setNr_credite(alDoileaCsv.getNr_credite());
      instantaDisciplinaPojo.setSemestru(alDoileaCsv.getSemestru());
      instantaDisciplinaPojos.add(instantaDisciplinaPojo);
    }

    List<DisciplinaGeneralPojo> disciplinaGeneralFaraDuplicate =
        new ArrayList<>(new HashSet<>(disciplinaGeneralPojos));
    List<InstantaDisciplinaPojo> instantaDisciplinaFaraDuplicate =
        new ArrayList<>(new HashSet<>(instantaDisciplinaPojos));

    final Connection connection = dataSource.getConnection();
    for (DisciplinaGeneralPojo disciplinaGeneralPojo : disciplinaGeneralFaraDuplicate) {
      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_DISCIPLINA_GENERAL)) {
        statement.setInt(1, disciplinaGeneralPojo.getId_disciplina());
        statement.setString(2, disciplinaGeneralPojo.getNume());
        statement.executeUpdate();
      }
    }

    for (InstantaDisciplinaPojo instantaDisciplinaPojo : instantaDisciplinaFaraDuplicate) {
      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_INSTANTA_DISCIPLINA)) {
        statement.setInt(1, instantaDisciplinaPojo.getId_instanta_disciplina());
        statement.setInt(2, instantaDisciplinaPojo.getId_disciplina());
        statement.setInt(3, instantaDisciplinaPojo.getId_profesor());
        statement.setInt(4, instantaDisciplinaPojo.getId_an_universitar());
        statement.setInt(5, instantaDisciplinaPojo.getNr_credite());
        statement.setInt(6, instantaDisciplinaPojo.getSemestru());
        statement.executeUpdate();
      }
    }
  }
}
