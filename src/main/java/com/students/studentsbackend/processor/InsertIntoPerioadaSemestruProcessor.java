package com.students.studentsbackend.processor;

import com.students.studentsbackend.StudentsConstants;
import com.students.studentsbackend.domain.AlTreileaCSV;
import com.students.studentsbackend.domain.PerioadaSemestruCsv;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

@Component
public class InsertIntoPerioadaSemestruProcessor implements Processor {

  private DataSource dataSource;

  public InsertIntoPerioadaSemestruProcessor(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void process(Exchange exchange) throws Exception {
    ArrayList<PerioadaSemestruCsv> exchangeBody = exchange.getIn().getBody(ArrayList.class);

    Connection connection = dataSource.getConnection();

    for (PerioadaSemestruCsv perioadaSemestruCsv : exchangeBody) {

      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_PERIOADA_SEMESTRU)) {
        statement.setInt(1, perioadaSemestruCsv.getId_perioada_semestru());
        statement.setInt(2, perioadaSemestruCsv.getNumar_semestru());
        statement.setString(3, perioadaSemestruCsv.getData_inceput());
        statement.setString(4, perioadaSemestruCsv.getData_sfarsit());
        statement.executeUpdate();
      }
    }
  }
}
