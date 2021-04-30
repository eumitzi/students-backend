package com.students.studentsbackend;

public class StudentsConstants {

    public static String INSERT_INTO_AN_STUDIU =
            "INSERT INTO an_studiu(id_an_studiu, an_studiu, id_ciclu_studiu, data_inceput, data_sfarsit, id_an_universitar) VALUES (?,?,?,?,?,?)";

    public static String INSERT_INTO_CICLU_STUDIU =
            "INSERT INTO ciclu_studiu(id_ciclu_studiu, tip_ciclu_studiu) VALUES (?,?)";

    public static String INSERT_INTO_AN_UNIVERSITAR = "INSERT INTO an_universitar(id_an_universitar, an_universitar, tip_an_universitar) VALUES (?,?,?)";

    public static String INSERT_INTO_PROGRAME_STUDIU =
            "INSERT INTO programe_studiu(id_programe_studiu,detaliu_program_studiu,id_ciclu_studiu) VALUES (?,?,?)";

    public static String INSERT_INTO_DISCIPLINA_GENERAL = "INSERT INTO discipline_general(id_disciplina, nume) VALUES (?,?)";
    public static String INSERT_INTO_INSTANTA_DISCIPLINA =
            "INSERT INTO instanta_disciplina(id_instanta_disciplina, id_disciplina, id_profesor, id_an_universitar, numar_credite, semestru) VALUES (?,?,?,?,?,?)";

    public static String INSERT_INTO_TIP_PERSOANE =
            "INSERT INTO tip_persoane(id_tip_persoane, tip_persoane) VALUES (?,?)";

    public static String INSERT_INTO_PERSOANE =
            "INSERT INTO persoane(id_persoana, id_tip_persoana, nume_persoana, prenume_persoana, adresa) VALUES (?,?,?,?,?)";

    public static String INSERT_INTO_PERIOADA_SEMESTRU =
            "INSERT INTO perioada_semestru(id_perioada_sem, numar_semestru, id_an_studiu, data_inceput, data_sfarsit) VALUES (?,?,?,?,?)";

}
