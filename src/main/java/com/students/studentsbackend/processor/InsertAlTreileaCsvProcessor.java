package com.students.studentsbackend.processor;

import com.students.studentsbackend.StudentsConstants;
import com.students.studentsbackend.domain.AlDoileaCsv;
import com.students.studentsbackend.domain.AlTreileaCSV;
import com.students.studentsbackend.pojos.DisciplinaGeneralPojo;
import com.students.studentsbackend.pojos.InstantaDisciplinaPojo;
import com.students.studentsbackend.pojos.PersoanePojo;
import com.students.studentsbackend.pojos.TipPersoanePojo;
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
public class InsertAlTreileaCsvProcessor implements Processor {

  private DataSource dataSource;

  public InsertAlTreileaCsvProcessor(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void process(Exchange exchange) throws Exception {

    ArrayList<AlTreileaCSV> exchangeBody = exchange.getIn().getBody(ArrayList.class);
    ArrayList<DisciplinaGeneralPojo> disciplinaGeneralPojos = new ArrayList<>();
    ArrayList<TipPersoanePojo> tipPersoanePojos = new ArrayList<>();
    ArrayList<PersoanePojo> persoanePojos = new ArrayList<>();

    for (AlTreileaCSV alTreileaCSV : exchangeBody) {
      // disciplina general
      DisciplinaGeneralPojo disciplinaGeneralPojo = new DisciplinaGeneralPojo();
      disciplinaGeneralPojo.setId_disciplina(alTreileaCSV.getId_disciplina());
      disciplinaGeneralPojo.setNume(alTreileaCSV.getNume());
      disciplinaGeneralPojos.add(disciplinaGeneralPojo);

      // tip persoane
      TipPersoanePojo tipPersoanePojo = new TipPersoanePojo();
      tipPersoanePojo.setId_tip_persoane(alTreileaCSV.getId_tip_persoane());
      tipPersoanePojo.setTip_persoane(alTreileaCSV.getTip_persoane());
      tipPersoanePojos.add(tipPersoanePojo);

      // persoane
      PersoanePojo persoanePojo = new PersoanePojo();
      persoanePojo.setId_persoana(alTreileaCSV.getId_persoana());
      persoanePojo.setAdresa(alTreileaCSV.getAdresa());
      persoanePojo.setId_tip_persoana(alTreileaCSV.getId_tip_persoane());
      persoanePojo.setNume(alTreileaCSV.getNume());
      persoanePojo.setPrenume(alTreileaCSV.getPrenume_persoana());
      persoanePojos.add(persoanePojo);
    }

    List<DisciplinaGeneralPojo> disciplinaGeneralFaraDuplicate =
        new ArrayList<>(new HashSet<>(disciplinaGeneralPojos));
    List<TipPersoanePojo> tipPersoaneFaraDuplicate =
        new ArrayList<>(new HashSet<>(tipPersoanePojos));
    List<PersoanePojo> persoaneFaraDuplicate = new ArrayList<>(new HashSet<>(persoanePojos));

    final Connection connection = dataSource.getConnection();
    for (DisciplinaGeneralPojo disciplinaGeneralPojo : disciplinaGeneralFaraDuplicate) {
      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_DISCIPLINA_GENERAL)) {
        statement.setInt(1, disciplinaGeneralPojo.getId_disciplina());
        statement.setString(2, disciplinaGeneralPojo.getNume());
        statement.executeUpdate();
      }
    }

    for (TipPersoanePojo tipPersoanePojo : tipPersoaneFaraDuplicate) {
      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_TIP_PERSOANE)) {
        statement.setInt(1, tipPersoanePojo.getId_tip_persoane());
        statement.setString(2, tipPersoanePojo.getTip_persoane());
        statement.executeUpdate();
      }
    }
    for (PersoanePojo persoanePojo : persoaneFaraDuplicate) {
      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_PERSOANE)) {
        statement.setInt(1, persoanePojo.getId_persoana());
        statement.setInt(2, persoanePojo.getId_tip_persoana());
        statement.setString(3, persoanePojo.getNume());
        statement.setString(4, persoanePojo.getPrenume());
        statement.setString(5, persoanePojo.getAdresa());
        statement.executeUpdate();
      }
    }
  }
}
