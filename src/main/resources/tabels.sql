SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
set FOREIGN_KEY_CHECKS=0;
CREATE SCHEMA IF NOT EXISTS `dizertatie` DEFAULT CHARACTER SET utf8 ;
USE `dizertatie` ;

-- -----------------------------------------------------
-- Table `disertatie`.`an_universitar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`an_universitar` ;

CREATE  TABLE IF NOT EXISTS `an_universitar` (
  `id_an_universitar` INT(11) NOT NULL AUTO_INCREMENT,
  `an_universitar` INT(11) NULL DEFAULT NULL ,
  `tip_an_universitar` VARCHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_an_universitar`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dizertatie`.`ciclu_studiu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`ciclu_studiu` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`ciclu_studiu` (
  `id_ciclu_studiu` INT(11) NOT NULL AUTO_INCREMENT,
  `tip_ciclu_studiu` CHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_ciclu_studiu`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`an_studiu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`an_studiu` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`an_studiu` (
  `id_an_studiu` INT(11) NOT NULL AUTO_INCREMENT,
  `an_studiu` INT(11) NULL DEFAULT NULL ,
  `id_ciclu_studiu` INT(11) NULL DEFAULT NULL ,
  `data_inceput` DATE NULL DEFAULT NULL ,
  `data_sfarsit` DATE NULL DEFAULT NULL ,
  `id_an_universitar` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_an_studiu`) ,
  INDEX `id_ciclu_studiu_idx` (`id_ciclu_studiu` ASC) ,
  INDEX `id_an_univ_anstd_idx` (`id_an_universitar` ASC) ,
  CONSTRAINT `id_an_univ_anstd`
    FOREIGN KEY (`id_an_universitar` )
    REFERENCES `dizertatie`.`an_universitar` (`id_an_universitar` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_ciclu_studiu`
    FOREIGN KEY (`id_ciclu_studiu`)
    REFERENCES `dizertatie`.`ciclu_studiu` (`id_ciclu_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`discipline_general`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`discipline_general` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`discipline_general` (
  `id_disciplina` INT(11) NOT NULL AUTO_INCREMENT,
  `nume` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_disciplina`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dizertatie`.`tip_persoane`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`tip_persoane` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`tip_persoane` (
  `id_tip_persoane` INT(11) NOT NULL AUTO_INCREMENT,
  `tip_persoane` CHAR(15) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_tip_persoane`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dizertatie`.`persoane`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`persoane` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`persoane` (
  `id_persoana` INT(11) NOT NULL AUTO_INCREMENT,
  `id_tip_persoana` INT(11) NULL DEFAULT NULL ,
  `nume_persoana` VARCHAR(45) NULL DEFAULT NULL ,
  `prenume_persoana` VARCHAR(45) NULL DEFAULT NULL ,
  `adresa` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_persoana`) ,
  INDEX `id_tip_persoana_idx` (`id_tip_persoana` ASC) ,
  CONSTRAINT `id_tip_persoana`
    FOREIGN KEY (`id_tip_persoana` )
    REFERENCES `dizertatie`.`tip_persoane` (`id_tip_persoane` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dizertatie`.`profesori`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`profesori` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`profesori` (
  `id_profesori` INT(11) NOT NULL AUTO_INCREMENT,
  `id_persoana` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_profesori`) ,
  INDEX `id_persoana_idx` (`id_persoana` ASC) ,
  CONSTRAINT `id_persoana_prof`
    FOREIGN KEY (`id_persoana` )
    REFERENCES `dizertatie`.`persoane` (`id_persoana` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dizertatie`.`instanta_disciplina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`instanta_disciplina` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`instanta_disciplina` (
  `id_instanta_disciplina` INT(11) NOT NULL AUTO_INCREMENT,
  `id_disciplina` INT(11) NULL DEFAULT NULL ,
  `id_profesor` INT(11) NULL DEFAULT NULL ,
  `id_an_universitar` INT(11) NULL DEFAULT NULL ,
  `numar_credite` INT(2) NULL DEFAULT NULL ,
  `semestru` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_instanta_disciplina`) ,
  INDEX `id_disciplina_id_idx` (`id_disciplina` ASC) ,
  INDEX `id_profesor_id_idx` (`id_profesor` ASC) ,
  INDEX `id_an_univ_id_idx` (`id_an_universitar` ASC) ,
  CONSTRAINT `id_an_univ_id`
    FOREIGN KEY (`id_an_universitar` )
    REFERENCES `dizertatie`.`an_universitar` (`id_an_universitar` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_disciplina_id`
    FOREIGN KEY (`id_disciplina` )
    REFERENCES `dizertatie`.`discipline_general` (`id_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_profesor_id`
    FOREIGN KEY (`id_profesor` )
    REFERENCES `dizertatie`.`profesori` (`id_profesori` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`note` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`note` (
  `id_nota` INT(11) NOT NULL AUTO_INCREMENT,
  `tip_nota` CHAR(15) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_nota`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dizertatie`.`studenti`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`studenti` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`studenti` (
  `id_student` INT(11) NOT NULL AUTO_INCREMENT,
  `nr_matricol` VARCHAR(8) NULL DEFAULT NULL ,
  `id_persoana` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_student`) ,
  INDEX `id_persoana_idx` (`id_persoana` ASC) ,
  CONSTRAINT `id_persoana_stud`
    FOREIGN KEY (`id_persoana` )
    REFERENCES `dizertatie`.`persoane` (`id_persoana` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`note_activitate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`note_activitate` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`note_activitate` (
  `id_nota_activitate` INT(11) NOT NULL AUTO_INCREMENT,
  `id_nota` INT(11) NULL DEFAULT NULL ,
  `data` DATE NULL DEFAULT NULL ,
  `id_student` INT(11) NULL DEFAULT NULL ,
  `id_instanta_disciplina` INT(11) NULL DEFAULT NULL ,
  `nota` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_nota_activitate`) ,
  INDEX `id_stud_nota_activ_idx` (`id_student` ASC) ,
  INDEX `id_inst_disciplina_nactiv_idx` (`id_instanta_disciplina` ASC) ,
  INDEX `id_nota_activitate_idx` (`id_nota` ASC) ,
  CONSTRAINT `id_inst_disciplina_nactiv`
    FOREIGN KEY (`id_instanta_disciplina` )
    REFERENCES `dizertatie`.`instanta_disciplina` (`id_instanta_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_nota_activitate`
    FOREIGN KEY (`id_nota` )
    REFERENCES `dizertatie`.`note` (`id_nota` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_stud_nota_activ`
    FOREIGN KEY (`id_student` )
    REFERENCES `dizertatie`.`studenti` (`id_student` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`note_examen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`note_examen` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`note_examen` (
  `id_nota_examen` INT(11) NOT NULL AUTO_INCREMENT,
  `id_nota` INT(11) NULL DEFAULT NULL ,
  `data` DATETIME NULL DEFAULT NULL ,
  `id_student` INT(11) NULL DEFAULT NULL ,
  `id_instanta_disciplina` INT(11) NULL DEFAULT NULL ,
  `nota` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_nota_examen`) ,
  INDEX `id_nota_examen_idx` (`id_nota` ASC) ,
  INDEX `id_stud_nota_exam_idx` (`id_student` ASC) ,
  INDEX `id_inst_disciplina_nexam_idx` (`id_instanta_disciplina` ASC) ,
  CONSTRAINT `id_inst_disciplina_nexam`
    FOREIGN KEY (`id_instanta_disciplina` )
    REFERENCES `dizertatie`.`instanta_disciplina` (`id_instanta_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_nota_examen`
    FOREIGN KEY (`id_nota` )
    REFERENCES `dizertatie`.`note` (`id_nota` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_stud_nota_exam`
    FOREIGN KEY (`id_student` )
    REFERENCES `dizertatie`.`studenti` (`id_student` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`note_finale`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`note_finale` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`note_finale` (
  `id_nota_finala` INT(11) NOT NULL AUTO_INCREMENT,
  `id_nota` INT(11) NULL DEFAULT NULL ,
  `data` DATETIME NULL DEFAULT NULL ,
  `id_student` INT(11) NULL DEFAULT NULL ,
  `id_instanta_disciplina` INT(11) NULL DEFAULT NULL ,
  `nota` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_nota_finala`) ,
  INDEX `id_nota_finala_idx` (`id_nota` ASC) ,
  INDEX `id_stud_nota_finala_idx` (`id_student` ASC) ,
  INDEX `id_inst_disciplina_nfinala_idx` (`id_instanta_disciplina` ASC) ,
  CONSTRAINT `id_inst_disciplina_nfinala`
    FOREIGN KEY (`id_instanta_disciplina` )
    REFERENCES `dizertatie`.`instanta_disciplina` (`id_instanta_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_nota_finala`
    FOREIGN KEY (`id_nota` )
    REFERENCES `dizertatie`.`note` (`id_nota` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_stud_nota_finala`
    FOREIGN KEY (`id_student` )
    REFERENCES `dizertatie`.`studenti` (`id_student` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`perioada_semestru`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`perioada_semestru` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`perioada_semestru` (
  `id_perioada_sem` INT(11) NOT NULL AUTO_INCREMENT,
  `numar_semestru` INT(1) NULL DEFAULT NULL ,
  `id_an_studiu` INT(11) NULL DEFAULT NULL ,
  `data_inceput` DATE NULL DEFAULT NULL ,
  `data_sfarsit` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`id_perioada_sem`) ,
  INDEX `id_an_studiu_persem_idx` (`id_an_studiu` ASC) ,
  CONSTRAINT `id_an_studiu_persem`
    FOREIGN KEY (`id_an_studiu` )
    REFERENCES `dizertatie`.`an_studiu` (`id_an_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dizertatie`.`programe_studiu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dizertatie`.`programe_studiu` ;

CREATE  TABLE IF NOT EXISTS `dizertatie`.`programe_studiu` (
  `id_programe_studiu` INT(11) NOT NULL AUTO_INCREMENT,
  `detaliu_program_studiu` VARCHAR(15) NULL DEFAULT NULL ,
  `id_ciclu_studiu` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_programe_studiu`) ,
  INDEX `id_ciclu_studiu_prgstd_idx` (`id_ciclu_studiu` ASC) ,
  CONSTRAINT `id_ciclu_studiu_prgstd`
    FOREIGN KEY (`id_ciclu_studiu` )
    REFERENCES `dizertatie`.`ciclu_studiu` (`id_ciclu_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `dizertatie` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=1;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;