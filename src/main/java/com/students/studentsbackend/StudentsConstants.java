package com.students.studentsbackend;

public class StudentsConstants {

    public static String INSERT_INTO_AN_STUDIU =
            "INSERT INTO an_studiu(id_an_studiu, an_studiu, id_ciclu_studiu, data_inceput, data_sfarsit, id_an_universitar) VALUES (?,?,?,?,?,?)";

    public static String INSERT_INTO_CICLU_STUDIU =
            "INSERT INTO ciclu_studiu(id_ciclu_studiu, tip_ciclu_studiu) VALUES (?,?)";

    public static String INSERT_INTO_AN_UNIVERSITAR = "INSERT INTO an_universitar(id_an_universitar, an_universitar, tip_an_universitar) VALUES (?,?,?)";

    public static String INSERT_INTO_PROGRAME_STUDIU =
            "INSERT INTO programe_studiu(id_programe_studiu,detaliu_program_studiu,id_ciclu_studiu) VALUES (?,?,?)";

}
