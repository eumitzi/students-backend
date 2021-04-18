package com.students.studentsbackend.processor;

import com.students.studentsbackend.domain.PrimulCSV;
import com.students.studentsbackend.pojos.CicluStudiuPojo;
import com.students.studentsbackend.pojos.ProgramaStudiuPojo;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class InsertIntoProgramaStudiuProcessor implements Processor {

  private DataSource dataSource;

  public InsertIntoProgramaStudiuProcessor(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  private static String INSERT_STRING =
      "INSERT INTO programe_studiu(id_programe_studiu,detaliu_program_studiu,id_ciclu_studiu) VALUES (?,?,?)";

  public void process(Exchange exchange) throws Exception {

    ArrayList<PrimulCSV> programeStudiu = exchange.getIn().getBody(ArrayList.class);
    ArrayList<ProgramaStudiuPojo> programeStudiuPojos = new ArrayList<>();

    for (PrimulCSV programaStudiu : programeStudiu) {
      ProgramaStudiuPojo programaStudiuPojo = new ProgramaStudiuPojo();
      programaStudiuPojo.setId_ciclu_studiu(programaStudiu.getId_ciclu_studiu());
      programaStudiuPojo.setId_prg_studiu(programaStudiu.getId_prg_studiu());
      programaStudiuPojo.setDetaliu(programaStudiu.getDetaliu());
      programeStudiuPojos.add(programaStudiuPojo);
    }
    List<ProgramaStudiuPojo> listWithoutDuplicates = new ArrayList<>(new HashSet<>(programeStudiuPojos));

    for (ProgramaStudiuPojo programaStudiuPojo : listWithoutDuplicates) {

      try (PreparedStatement statement =
          dataSource.getConnection().prepareStatement(INSERT_STRING)) {
        statement.setInt(1, programaStudiuPojo.getId_prg_studiu());
        statement.setString(2, programaStudiuPojo.getDetaliu());
        statement.setInt(3, programaStudiuPojo.getId_ciclu_studiu());
        statement.executeUpdate();
      }
    }
  }
}
