package com.students.studentsbackend.processor;

import com.students.studentsbackend.StudentsConstants;
import com.students.studentsbackend.domain.PrimulCSV;
import com.students.studentsbackend.pojos.AnStudiuPojo;
import com.students.studentsbackend.pojos.AnUniversitarPojo;
import com.students.studentsbackend.pojos.CicluStudiuPojo;
import com.students.studentsbackend.pojos.ProgramaStudiuPojo;
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
public class InsertPrimulCsvProcessor implements Processor {

  private DataSource dataSource;

  public InsertPrimulCsvProcessor(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void process(Exchange exchange) throws Exception {

    ArrayList<PrimulCSV> exchangeBody = exchange.getIn().getBody(ArrayList.class);
    ArrayList<AnStudiuPojo> anStudiuPojos = new ArrayList<>();
    ArrayList<AnUniversitarPojo> anUniversitarPojos = new ArrayList<>();
    ArrayList<CicluStudiuPojo> cicluStudiuPojos = new ArrayList<>();
    ArrayList<ProgramaStudiuPojo> programeStudiuPojos = new ArrayList<>();

    for (PrimulCSV primulCSV : exchangeBody) {

      // an studiu
      AnStudiuPojo anStudiuPojo = new AnStudiuPojo();
      anStudiuPojo.setAn_studiu(primulCSV.getAn_studiu());
      anStudiuPojo.setData_inceput(primulCSV.getData_inceput());
      anStudiuPojo.setData_sfarsit(primulCSV.getData_sfarsit());
      anStudiuPojo.setId_an_studiu(primulCSV.getId_an_studiu());
      anStudiuPojo.setId_ciclu_studiu(primulCSV.getId_ciclu_studiu());
      anStudiuPojo.setId_an_universitar(primulCSV.getId_an_universitar());
      anStudiuPojos.add(anStudiuPojo);

      // an universitar
      AnUniversitarPojo anUniversitarPojo = new AnUniversitarPojo();
      anUniversitarPojo.setId_an_universitar(primulCSV.getId_an_universitar());
      anUniversitarPojo.setTip_an_universitar(primulCSV.getTip_an_universitar());
      anUniversitarPojo.setAn_universitar(primulCSV.getAn_universitar());
      anUniversitarPojos.add(anUniversitarPojo);

      // ciclu studiu
      CicluStudiuPojo cicluStudiuPojo = new CicluStudiuPojo();
      cicluStudiuPojo.setId_ciclu_studiu(primulCSV.getId_ciclu_studiu());
      cicluStudiuPojo.setTip_ciclu_studiu(primulCSV.getTip_ciclu_studiu());
      cicluStudiuPojos.add(cicluStudiuPojo);

      // programe studiu
      ProgramaStudiuPojo programaStudiuPojo = new ProgramaStudiuPojo();
      programaStudiuPojo.setId_ciclu_studiu(primulCSV.getId_ciclu_studiu());
      programaStudiuPojo.setId_prg_studiu(primulCSV.getId_prg_studiu());
      programaStudiuPojo.setDetaliu(primulCSV.getDetaliu());
      programeStudiuPojos.add(programaStudiuPojo);

    }

    List<AnUniversitarPojo> anUniversitarFaraDuplicate = new ArrayList<>(new HashSet<>(anUniversitarPojos));
    List<AnStudiuPojo> anStudiuFaraDuplicate = new ArrayList<>(new HashSet<>(anStudiuPojos));
    List<CicluStudiuPojo> cicluStudiuFaraDuplicate = new ArrayList<>(new HashSet<>(cicluStudiuPojos));
    List<ProgramaStudiuPojo> programeStudiuFaraDuplicate = new ArrayList<>(new HashSet<>(programeStudiuPojos));


    final Connection connection = dataSource.getConnection();
    for (CicluStudiuPojo cicluStudiuPojo : cicluStudiuFaraDuplicate) {
      try (PreparedStatement statement =
                   connection.prepareStatement(StudentsConstants.INSERT_INTO_CICLU_STUDIU)) {
        statement.setInt(1, cicluStudiuPojo.getId_ciclu_studiu());
        statement.setString(2, cicluStudiuPojo.getTip_ciclu_studiu());
        statement.executeUpdate();
      }
    }

    for (AnUniversitarPojo anUniversitarPojo : anUniversitarFaraDuplicate) {
      try (PreparedStatement statement = connection.prepareStatement(StudentsConstants.INSERT_INTO_AN_UNIVERSITAR)) {
        statement.setInt(1, anUniversitarPojo.getId_an_universitar());
        statement.setInt(2, anUniversitarPojo.getAn_universitar());
        statement.setString(3, anUniversitarPojo.getTip_an_universitar());
        statement.executeUpdate();
      }
    }

    for (ProgramaStudiuPojo programaStudiuPojo : programeStudiuFaraDuplicate) {
      try (PreparedStatement statement =
                   connection.prepareStatement(StudentsConstants.INSERT_INTO_PROGRAME_STUDIU)) {
        statement.setInt(1, programaStudiuPojo.getId_prg_studiu());
        statement.setString(2, programaStudiuPojo.getDetaliu());
        statement.setInt(3, programaStudiuPojo.getId_ciclu_studiu());
        statement.executeUpdate();
      }
    }

    for (AnStudiuPojo anStudiuPojo : anStudiuFaraDuplicate) {
      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_AN_STUDIU)) {
        statement.setInt(1, anStudiuPojo.getId_an_studiu());
        statement.setInt(2, anStudiuPojo.getAn_studiu());
        statement.setInt(3, anStudiuPojo.getId_ciclu_studiu());
        statement.setString(4, anStudiuPojo.getData_inceput());
        statement.setString(5, anStudiuPojo.getData_sfarsit());
        statement.setInt(6, anStudiuPojo.getId_an_universitar());
        statement.executeUpdate();
      }
    }
  }
}
