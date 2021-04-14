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
public class InsertIntoAnUniversitarProcessor implements Processor {

    private DataSource dataSource;

    public InsertIntoAnUniversitarProcessor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static String INSERT_STRING = "INSERT INTO an_universitar(id_an_universitar, an_universitar, tip_an_universitar) VALUES (?,?,?)";

    public void process(Exchange exchange) throws Exception {

        ArrayList<PrimulCSV> anUniversitari = exchange.getIn().getBody(ArrayList.class);

        for (PrimulCSV anUniversitar : anUniversitari) {
            try (PreparedStatement statement = dataSource.getConnection().prepareStatement(INSERT_STRING)) {
                statement.setInt(1, anUniversitar.getId_an_universitar());
                statement.setInt(2, anUniversitar.getAn_universitar());
                statement.setString(3, anUniversitar.getTip_an_universitar());
                statement.executeUpdate();
            }
        }
    }
}
