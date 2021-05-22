package com.students.studentsbackend.processor;

import com.students.studentsbackend.StudentsConstants;
import com.students.studentsbackend.domain.NotaCSV;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

@Component
public class InsertIntoNotaProcessor implements Processor {

  private DataSource dataSource;

  public InsertIntoNotaProcessor(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void process(Exchange exchange) throws Exception {

    ArrayList<NotaCSV> exchangeBody = exchange.getIn().getBody(ArrayList.class);
    Connection connection = dataSource.getConnection();
    for (NotaCSV notaCSV : exchangeBody) {
      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_NOTE)) {
        statement.setInt(1, notaCSV.getId_nota());
        statement.setString(2, notaCSV.getTip_nota());
        statement.executeUpdate();
      }
    }
  }
}
