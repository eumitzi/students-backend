package com.students.studentsbackend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("routeuri")

public class StudentsConfig {

    private String sourceDirectory;
    private String fileName;
    private String noteCsv;
    private String fileNameCSV3;
    private String perioadaSemestruCsv;
    private String instantaDisciplinaCsv;
    private String studentProfesorCsv;

    public String getPerioadaSemestruCsv() {
        return perioadaSemestruCsv;
    }

    public void setPerioadaSemestruCsv(String perioadaSemestruCsv) {
        this.perioadaSemestruCsv = perioadaSemestruCsv;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }

    public String getNoteCsv() {
        return noteCsv;
    }

    public void setNoteCsv(String noteCsv) {
        this.noteCsv = noteCsv;
    }

    public String getFileNameCSV3() {
        return fileNameCSV3;
    }

    public void setFileNameCSV3(String fileNameCSV3) {
        this.fileNameCSV3 = fileNameCSV3;
    }

    public String getInstantaDisciplinaCsv() {
        return instantaDisciplinaCsv;
    }

    public void setInstantaDisciplinaCsv(String instantaDisciplinaCsv) {
        this.instantaDisciplinaCsv = instantaDisciplinaCsv;
    }

    public String getStudentProfesorCsv() {
        return studentProfesorCsv;
    }

    public void setStudentProfesorCsv(String studentProfesorCsv) {
        this.studentProfesorCsv = studentProfesorCsv;
    }
}
