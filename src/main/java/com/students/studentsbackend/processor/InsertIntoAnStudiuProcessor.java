package com.students.studentsbackend.processor;

import com.students.studentsbackend.domain.PrimulCSV;
import com.students.studentsbackend.domain.Student;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;

@Component
public class InsertIntoAnStudiuProcessor implements Processor {

    private DataSource dataSource;

    public InsertIntoAnStudiuProcessor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static String INSERT_STRING = "INSERT INTO an_studiu(id_an_studiu, an_studiu, id_ciclu_studiu, data_inceput, data_sfarsit, id_an_universitar) VALUES (?,?,?,?,?,?)";

    public void process(Exchange exchange) throws Exception {

        ArrayList<PrimulCSV> aniStudiu = exchange.getIn().getBody(ArrayList.class);

        for (PrimulCSV anStudiu : aniStudiu) {
            try (PreparedStatement statement = dataSource.getConnection().prepareStatement(INSERT_STRING)) {
                statement.setInt(1, anStudiu.getId_an_studiu());
                statement.setInt(2, anStudiu.getAn_studiu());
                statement.setInt(3, anStudiu.getId_ciclu_studiu());
                statement.setString(4, anStudiu.getData_inceput());
                statement.setString(5, anStudiu.getData_sfarsit());
                statement.setInt(6, anStudiu.getId_an_universitar());
                statement.execute();
            }
        }
    }
}
