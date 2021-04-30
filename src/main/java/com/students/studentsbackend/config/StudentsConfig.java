package com.students.studentsbackend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("routeuri")
public class StudentsConfig {

    private String sourceDirectory;
    private String fileName;
    private String fileNameCsv2;
    private String fileNameCSV3;
    private String perioadaSemestruCsv;
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

    public String getFileNameCsv2() {
        return fileNameCsv2;
    }

    public void setFileNameCsv2(String fileNameCsv2) {
        this.fileNameCsv2 = fileNameCsv2;
    }

    public String getFileNameCSV3() {
        return fileNameCSV3;
    }

    public void setFileNameCSV3(String fileNameCSV3) {
        this.fileNameCSV3 = fileNameCSV3;
    }
}
