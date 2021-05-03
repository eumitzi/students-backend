package com.students.studentsbackend.processor;

import com.students.studentsbackend.StudentsConstants;
import com.students.studentsbackend.domain.AlDoileaCsv;
import com.students.studentsbackend.domain.StudentProfesorCSV;
import com.students.studentsbackend.pojos.DisciplinaGeneralPojo;
import com.students.studentsbackend.pojos.InstantaDisciplinaPojo;
import com.students.studentsbackend.pojos.ProfesoriPojo;
import com.students.studentsbackend.pojos.StudentPojo;
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
public class InsertStudentProfesorProcessor implements Processor {

  private DataSource dataSource;

  public InsertStudentProfesorProcessor(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void process(Exchange exchange) throws Exception {

    ArrayList<StudentProfesorCSV> exchangeBody = exchange.getIn().getBody(ArrayList.class);
    ArrayList<StudentPojo> studentProfesorPojos = new ArrayList<>();
    ArrayList<ProfesoriPojo> profesoriPojos = new ArrayList<>();

    for (StudentProfesorCSV studentProfesorCSV : exchangeBody) {
      // student
      StudentPojo studentPojo = new StudentPojo();
      studentPojo.setId_student(studentProfesorCSV.getId_student());
      studentPojo.setId_persoana(studentProfesorCSV.getId_persoana_stud());
      studentPojo.setNr_matricol(studentProfesorCSV.getNr_matricol());
      studentProfesorPojos.add(studentPojo);

      // instanta disciplina
      ProfesoriPojo profesoriPojo = new ProfesoriPojo();
      profesoriPojo.setId_profesori(studentProfesorCSV.getId_profesori());
      profesoriPojo.setId_persoana(studentProfesorCSV.getId_persoana());
      profesoriPojos.add(profesoriPojo);
    }

    List<StudentPojo> studentPojosFaraDuplicate =
        new ArrayList<>(new HashSet<>(studentProfesorPojos));
    List<ProfesoriPojo> profesoriPojosFaraDuplicate =
        new ArrayList<>(new HashSet<>(profesoriPojos));

    final Connection connection = dataSource.getConnection();
    for (StudentPojo studentPojo : studentPojosFaraDuplicate) {
      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_STUDENTI)) {
        statement.setInt(1, studentPojo.getId_student());
        statement.setString(2, studentPojo.getNr_matricol());
        statement.setInt(3, studentPojo.getId_persoana());
        statement.executeUpdate();
      }
    }

    for (ProfesoriPojo profesoriPojo : profesoriPojosFaraDuplicate) {
      try (PreparedStatement statement =
          connection.prepareStatement(StudentsConstants.INSERT_INTO_PROFESORI)) {
        statement.setInt(1, profesoriPojo.getId_profesori());
        statement.setInt(2, profesoriPojo.getId_persoana());
       statement.executeUpdate();
      }
    }
  }
}
