package com.students.studentsbackend.processor;

import com.students.studentsbackend.pojos.CicluStudiuPojo;
import com.students.studentsbackend.domain.PrimulCSV;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class InsertIntoCicluStudiuProcessor implements Processor {

  private DataSource dataSource;

  public InsertIntoCicluStudiuProcessor(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  private static String INSERT_STRING =
      "INSERT INTO ciclu_studiu(id_ciclu_studiu, tip_ciclu_studiu) VALUES (?,?)";

  public void process(Exchange exchange) throws Exception {

    ArrayList<PrimulCSV> cicluriStudiu = exchange.getIn().getBody(ArrayList.class);
    ArrayList<CicluStudiuPojo> pojos = new ArrayList<>();

    for (PrimulCSV cicluStudiu : cicluriStudiu) {
      CicluStudiuPojo cicluStudiuPojo = new CicluStudiuPojo();
      cicluStudiuPojo.setId_ciclu_studiu(cicluStudiu.getId_ciclu_studiu());
      cicluStudiuPojo.setTip_ciclu_studiu(cicluStudiu.getTip_ciclu_studiu());
      pojos.add(cicluStudiuPojo);
    }
    List<CicluStudiuPojo> listWithoutDuplicates = new ArrayList<>(new HashSet<>(pojos));

    for (CicluStudiuPojo cicluStudiuPojo : listWithoutDuplicates) {

      try (PreparedStatement statement =
          dataSource.getConnection().prepareStatement(INSERT_STRING)) {
        statement.setInt(1, cicluStudiuPojo.getId_ciclu_studiu());
        statement.setString(2, cicluStudiuPojo.getTip_ciclu_studiu());
        statement.executeUpdate();
      }
    }
  }
}
