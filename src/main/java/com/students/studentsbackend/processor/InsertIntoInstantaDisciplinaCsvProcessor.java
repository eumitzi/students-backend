package com.students.studentsbackend.processor;

import com.students.studentsbackend.StudentsConstants;
import com.students.studentsbackend.domain.AlDoileaCsv;
import com.students.studentsbackend.domain.InstantaDisciplinaCsv;
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
public class InsertIntoInstantaDisciplinaCsvProcessor implements Processor {

  private DataSource dataSource;

  public InsertIntoInstantaDisciplinaCsvProcessor(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void process(Exchange exchange) throws Exception {

    ArrayList<InstantaDisciplinaCsv> exchangeBody = exchange.getIn().getBody(ArrayList.class);
    ArrayList<InstantaDisciplinaPojo> InstantaDisciplinaPojos = new ArrayList<>();

    for (InstantaDisciplinaCsv instantaDisciplinaCsv : exchangeBody) {
      // instanta disciplina
      InstantaDisciplinaPojo instantaDisciplinaPojo = new InstantaDisciplinaPojo();
      instantaDisciplinaPojo.setId_instanta_disciplina(instantaDisciplinaCsv.getId_instanta_disciplina());
      instantaDisciplinaPojo.setId_an_universitar(instantaDisciplinaCsv.getId_an_universitar());
      instantaDisciplinaPojo.setId_an_studiu(instantaDisciplinaCsv.getId_an_studiu());
      instantaDisciplinaPojo.setId_disciplina(instantaDisciplinaCsv.getId_disciplina());
      instantaDisciplinaPojo.setNumar_credite(instantaDisciplinaCsv.getNumar_credite());
      instantaDisciplinaPojo.setSemestru(instantaDisciplinaCsv.getSemestru());
      instantaDisciplinaPojo.setId_student(instantaDisciplinaCsv.getId_student());
      instantaDisciplinaPojo.setFactor_k(instantaDisciplinaCsv.getFactor_k());
      instantaDisciplinaPojo.setId_profesor(instantaDisciplinaCsv.getId_profesor());

      InstantaDisciplinaPojos.add(instantaDisciplinaPojo);
    }

    List<InstantaDisciplinaPojo> instantaDisciplinaFaraDuplicate =
        new ArrayList<>(new HashSet<>(InstantaDisciplinaPojos));

    final Connection connection = dataSource.getConnection();

    for (InstantaDisciplinaPojo instantaDisciplinaPojo : instantaDisciplinaFaraDuplicate) {
      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_INSTANTA_DISCIPLINA)) {
        statement.setInt(1, instantaDisciplinaPojo.getId_instanta_disciplina());
        statement.setInt(2, instantaDisciplinaPojo.getId_disciplina());
        statement.setInt(3, instantaDisciplinaPojo.getId_an_studiu());
        statement.setInt(4, instantaDisciplinaPojo.getId_profesor());
        statement.setInt(5, instantaDisciplinaPojo.getId_an_universitar());
        statement.setInt(6, instantaDisciplinaPojo.getNumar_credite());
        statement.setInt(7, instantaDisciplinaPojo.getSemestru());
        statement.setInt(8, instantaDisciplinaPojo.getId_student());
        statement.setDouble(9, instantaDisciplinaPojo.getFactor_k());
        statement.executeUpdate();
      }
    }
  }
}
