package com.students.studentsbackend.processor;

import com.students.studentsbackend.domain.PrimulCSV;
import com.students.studentsbackend.domain.Student;
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

    private static String INSERT_STRING = "INSERT INTO ciclu_studiu(id_ciclu_studiu, tip_ciclu_studiu) VALUES (?,?)";

    public void process(Exchange exchange) throws Exception {

        ArrayList<PrimulCSV> cicluriStudiu = exchange.getIn().getBody(ArrayList.class);

        for (PrimulCSV cicluStudiu : cicluriStudiu) {
            try (PreparedStatement statement = dataSource.getConnection().prepareStatement(INSERT_STRING)) {
                statement.setInt(1, cicluStudiu.getId_ciclu_studiu());
                statement.setString(2, cicluStudiu.getTip_ciclu_studiu());
                statement.executeUpdate();
            }

        }
    }
}
