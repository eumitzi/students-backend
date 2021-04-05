package com.students.studentsbackend.processor;

import com.students.studentsbackend.domain.Student;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;

@Component
public class InsertProcessor implements Processor {

    private DataSource dataSource;

    public InsertProcessor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static String INSERT_STRING = "INSERT INTO persoane(id, nume, varsta) VALUES (?,?,?)";

    public void process(Exchange exchange) throws Exception {

        ArrayList<Student> students = exchange.getIn().getBody(ArrayList.class);

        for (Student student : students) {
            try (PreparedStatement statement = dataSource.getConnection().prepareStatement(INSERT_STRING)) {
                statement.setInt(1, student.getId());
                statement.setString(2, student.getPrenume());
                statement.setInt(3, student.getVarsta());
                statement.executeUpdate();
            }
        }
    }
}
