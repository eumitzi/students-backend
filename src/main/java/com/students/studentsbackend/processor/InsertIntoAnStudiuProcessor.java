package com.students.studentsbackend.processor;

import com.students.studentsbackend.domain.PrimulCSV;
import com.students.studentsbackend.pojos.AnStudiuPojo;
import com.students.studentsbackend.pojos.CicluStudiuPojo;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class InsertIntoAnStudiuProcessor implements Processor {

    private DataSource dataSource;

    public InsertIntoAnStudiuProcessor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static String INSERT_STRING = "INSERT INTO an_studiu(id_an_studiu, an_studiu, id_ciclu_studiu, data_inceput, data_sfarsit, id_an_universitar) VALUES (?,?,?,?,?,?)";

    public void process(Exchange exchange) throws Exception {

        ArrayList<PrimulCSV> aniStudiu = exchange.getIn().getBody(ArrayList.class);
        ArrayList<AnStudiuPojo> anStudiuPojos = new ArrayList<>();

        for(PrimulCSV primulCSV : aniStudiu){
            AnStudiuPojo anStudiuPojo = new AnStudiuPojo();
            anStudiuPojo.setAn_studiu(primulCSV.getAn_studiu());
            anStudiuPojo.setData_inceput(primulCSV.getData_inceput());
            anStudiuPojo.setData_sfarsit(primulCSV.getData_sfarsit());
            anStudiuPojo.setId_an_studiu(primulCSV.getId_an_studiu());
            anStudiuPojo.setId_ciclu_studiu(primulCSV.getId_ciclu_studiu());
            anStudiuPojo.setId_an_universitar(primulCSV.getId_an_universitar());
            anStudiuPojos.add(anStudiuPojo);
        }

        List<AnStudiuPojo> listWithoutDuplicates = new ArrayList<>(new HashSet<>(anStudiuPojos));

        for (AnStudiuPojo anStudiuPojo : listWithoutDuplicates) {
            try (PreparedStatement statement = dataSource.getConnection().prepareStatement(INSERT_STRING)) {
                statement.setInt(1, anStudiuPojo.getId_an_studiu());
                statement.setInt(2, anStudiuPojo.getAn_studiu());
                statement.setInt(3, anStudiuPojo.getId_ciclu_studiu());
                statement.setString(4, anStudiuPojo.getData_inceput());
                statement.setString(5, anStudiuPojo.getData_sfarsit());
                statement.setInt(6, anStudiuPojo.getId_an_universitar());
                statement.execute();
            }
        }
    }
}
