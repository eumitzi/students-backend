SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `disertatie` ;
CREATE SCHEMA IF NOT EXISTS `disertatie` DEFAULT CHARACTER SET utf8 ;
USE `disertatie` ;

-- -----------------------------------------------------
-- Table `disertatie`.`an_universitar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`an_universitar` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`an_universitar` (
  `id_an_universitar` INT(11) NOT NULL ,
  `an_universitar` INT(11) NULL DEFAULT NULL ,
  `tip_an_universitar` VARCHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_an_universitar`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`ciclu_studiu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`ciclu_studiu` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`ciclu_studiu` (
  `id_ciclu_studiu` INT(11) NOT NULL ,
  `tip_ciclu_studiu` CHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_ciclu_studiu`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`an_studiu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`an_studiu` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`an_studiu` (
  `id_an_studiu` INT(11) NOT NULL ,
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
    REFERENCES `disertatie`.`an_universitar` (`id_an_universitar` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_ciclu_studiu`
    FOREIGN KEY (`id_ciclu_studiu` )
    REFERENCES `disertatie`.`ciclu_studiu` (`id_ciclu_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`anstd_ciclustd`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`anstd_ciclustd` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`anstd_ciclustd` (
  `id_an_studiu` INT(11) NOT NULL ,
  `id_ciclu_studiu` INT(11) NOT NULL ,
  PRIMARY KEY (`id_an_studiu`, `id_ciclu_studiu`) ,
  INDEX `id_anstd_ascs_idx` (`id_an_studiu` ASC) ,
  INDEX `id_ciclustd_ascs_idx` (`id_ciclu_studiu` ASC) ,
  CONSTRAINT `id_anstd_ascs`
    FOREIGN KEY (`id_an_studiu` )
    REFERENCES `disertatie`.`an_studiu` (`id_an_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_ciclustd_ascs`
    FOREIGN KEY (`id_ciclu_studiu` )
    REFERENCES `disertatie`.`ciclu_studiu` (`id_ciclu_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`perioada_semestru`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`perioada_semestru` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`perioada_semestru` (
  `id_perioada_sem` INT(11) NOT NULL ,
  `numar_semestru` INT(1) NULL DEFAULT NULL ,
  `id_an_studiu` INT(11) NULL DEFAULT NULL ,
  `data_inceput` DATE NULL DEFAULT NULL ,
  `data_sfarsit` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`id_perioada_sem`) ,
  INDEX `id_an_studiu_persem_idx` (`id_an_studiu` ASC) ,
  CONSTRAINT `id_an_studiu_persem`
    FOREIGN KEY (`id_an_studiu` )
    REFERENCES `disertatie`.`an_studiu` (`id_an_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`anstd_persem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`anstd_persem` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`anstd_persem` (
  `id_an_studiu` INT(11) NOT NULL ,
  `id_perioada_sem` INT(11) NOT NULL ,
  PRIMARY KEY (`id_an_studiu`, `id_perioada_sem`) ,
  INDEX `id_persem_asps_idx` (`id_perioada_sem` ASC) ,
  INDEX `id_anstd_asps_idx` (`id_an_studiu` ASC) ,
  CONSTRAINT `id_anstd_asps`
    FOREIGN KEY (`id_an_studiu` )
    REFERENCES `disertatie`.`an_studiu` (`id_an_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_persem_asps`
    FOREIGN KEY (`id_perioada_sem` )
    REFERENCES `disertatie`.`perioada_semestru` (`id_perioada_sem` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`anstudiu_ciclustd`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`anstudiu_ciclustd` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`anstudiu_ciclustd` (
  `id_an_studiu` INT(11) NOT NULL ,
  `id_ciclu_studiu` INT(11) NOT NULL ,
  PRIMARY KEY (`id_an_studiu`, `id_ciclu_studiu`) ,
  INDEX `id_ciclustd_ascs_idx` (`id_ciclu_studiu` ASC) ,
  CONSTRAINT `id_anstd_ascs_idx`
    FOREIGN KEY (`id_an_studiu` )
    REFERENCES `disertatie`.`an_studiu` (`id_an_studiu` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `id_ciclustd_ascs_idx`
    FOREIGN KEY (`id_ciclu_studiu` )
    REFERENCES `disertatie`.`ciclu_studiu` (`id_ciclu_studiu` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`programe_studiu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`programe_studiu` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`programe_studiu` (
  `id_programe_studiu` INT(11) NOT NULL ,
  `detaliu_program_studiu` VARCHAR(15) NULL DEFAULT NULL ,
  `id_ciclu_studiu` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_programe_studiu`) ,
  INDEX `id_ciclu_studiu_prgstd_idx` (`id_ciclu_studiu` ASC) ,
  CONSTRAINT `id_ciclu_studiu_prgstd`
    FOREIGN KEY (`id_ciclu_studiu` )
    REFERENCES `disertatie`.`ciclu_studiu` (`id_ciclu_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`ciclustd_prgstd`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`ciclustd_prgstd` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`ciclustd_prgstd` (
  `id_ciclu_studiu` INT(11) NOT NULL ,
  `id_programe_studiu` INT(11) NOT NULL ,
  PRIMARY KEY (`id_ciclu_studiu`, `id_programe_studiu`) ,
  INDEX `id_ciclustd_csps_idx` (`id_ciclu_studiu` ASC) ,
  INDEX `id_prgstd_csps_idx` (`id_programe_studiu` ASC) ,
  CONSTRAINT `id_ciclustd_csps`
    FOREIGN KEY (`id_ciclu_studiu` )
    REFERENCES `disertatie`.`ciclu_studiu` (`id_ciclu_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_prgstd_csps`
    FOREIGN KEY (`id_programe_studiu` )
    REFERENCES `disertatie`.`programe_studiu` (`id_programe_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`discipline_general`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`discipline_general` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`discipline_general` (
  `id_disciplina` INT(11) NOT NULL ,
  `nume` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_disciplina`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`tip_persoane`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`tip_persoane` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`tip_persoane` (
  `id_tip_persoane` INT(11) NOT NULL ,
  `tip_persoane` CHAR(15) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_tip_persoane`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`persoane`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`persoane` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`persoane` (
  `id_persoana` INT(11) NOT NULL ,
  `id_tip_persoana` INT(11) NULL DEFAULT NULL ,
  `nume_persoana` VARCHAR(45) NULL DEFAULT NULL ,
  `prenume_persoana` VARCHAR(45) NULL DEFAULT NULL ,
  `adresa` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_persoana`) ,
  INDEX `id_tip_persoana_idx` (`id_tip_persoana` ASC) ,
  CONSTRAINT `id_tip_persoana`
    FOREIGN KEY (`id_tip_persoana` )
    REFERENCES `disertatie`.`tip_persoane` (`id_tip_persoane` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`profesori`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`profesori` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`profesori` (
  `id_profesori` INT(11) NOT NULL ,
  `id_persoana` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_profesori`) ,
  INDEX `id_persoana_idx` (`id_persoana` ASC) ,
  CONSTRAINT `id_persoana_prof`
    FOREIGN KEY (`id_persoana` )
    REFERENCES `disertatie`.`persoane` (`id_persoana` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`studenti`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`studenti` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`studenti` (
  `id_student` INT(11) NOT NULL ,
  `nr_matricol` VARCHAR(8) NULL DEFAULT NULL ,
  `id_persoana` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_student`) ,
  INDEX `id_persoana_idx` (`id_persoana` ASC) ,
  CONSTRAINT `id_persoana_stud`
    FOREIGN KEY (`id_persoana` )
    REFERENCES `disertatie`.`persoane` (`id_persoana` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`instanta_disciplina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`instanta_disciplina` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`instanta_disciplina` (
  `id_instanta_disciplina` INT(11) NOT NULL ,
  `id_disciplina` INT(11) NULL DEFAULT NULL ,
  `id_profesor` INT(11) NULL DEFAULT NULL ,
  `id_an_studiu` INT(11) NULL DEFAULT NULL ,
  `id_an_universitar` INT(11) NULL DEFAULT NULL ,
  `numar_credite` INT(2) NULL DEFAULT NULL ,
  `semestru` INT(11) NULL DEFAULT NULL ,
  `id_student` INT(11) NULL DEFAULT NULL ,
  `factor_k` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_instanta_disciplina`) ,
  INDEX `id_disciplina_id_idx` (`id_disciplina` ASC) ,
  INDEX `id_profesor_id_idx` (`id_profesor` ASC) ,
  INDEX `id_an_univ_id_idx` (`id_an_universitar` ASC) ,
  INDEX `id_student_id_idx` (`id_student` ASC) ,
  INDEX `id_an_studiu_id_idx` (`id_an_studiu` ASC) ,
  CONSTRAINT `id_an_studiu_id`
    FOREIGN KEY (`id_an_studiu` )
    REFERENCES `disertatie`.`an_studiu` (`id_an_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_an_univ_id`
    FOREIGN KEY (`id_an_universitar` )
    REFERENCES `disertatie`.`an_universitar` (`id_an_universitar` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_disciplina_id`
    FOREIGN KEY (`id_disciplina` )
    REFERENCES `disertatie`.`discipline_general` (`id_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_profesor_id`
    FOREIGN KEY (`id_profesor` )
    REFERENCES `disertatie`.`profesori` (`id_profesori` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_student_id`
    FOREIGN KEY (`id_student` )
    REFERENCES `disertatie`.`studenti` (`id_student` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`note` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`note` (
  `id_nota` INT(11) NOT NULL ,
  `tip_nota` CHAR(15) NULL DEFAULT NULL ,
  PRIMARY KEY (`id_nota`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`note_activitate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`note_activitate` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`note_activitate` (
  `id_nota_activitate` INT(11) NOT NULL ,
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
    REFERENCES `disertatie`.`instanta_disciplina` (`id_instanta_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_nota_activitate`
    FOREIGN KEY (`id_nota` )
    REFERENCES `disertatie`.`note` (`id_nota` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_stud_nota_activ`
    FOREIGN KEY (`id_student` )
    REFERENCES `disertatie`.`studenti` (`id_student` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`note_examen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`note_examen` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`note_examen` (
  `id_nota_examen` INT(11) NOT NULL ,
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
    REFERENCES `disertatie`.`instanta_disciplina` (`id_instanta_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_nota_examen`
    FOREIGN KEY (`id_nota` )
    REFERENCES `disertatie`.`note` (`id_nota` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_stud_nota_exam`
    FOREIGN KEY (`id_student` )
    REFERENCES `disertatie`.`studenti` (`id_student` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`note_finale`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`note_finale` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`note_finale` (
  `id_nota_finala` INT(11) NOT NULL ,
  `id_nota` INT(11) NULL DEFAULT NULL ,
  `data` DATETIME NULL DEFAULT NULL ,
  `id_student` INT(11) NULL DEFAULT NULL ,
  `id_instanta_disciplina` INT(11) NULL DEFAULT NULL ,
  `nota_examen` FLOAT NULL DEFAULT NULL ,
  `nota_activitate` FLOAT NULL DEFAULT NULL ,
  `medie_finala` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_nota_finala`) ,
  INDEX `id_nota_finala_idx` (`id_nota` ASC) ,
  INDEX `id_stud_nota_finala_idx` (`id_student` ASC) ,
  INDEX `id_inst_disciplina_nfinala_idx` (`id_instanta_disciplina` ASC) ,
  CONSTRAINT `id_inst_disciplina_nfinala`
    FOREIGN KEY (`id_instanta_disciplina` )
    REFERENCES `disertatie`.`instanta_disciplina` (`id_instanta_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_nota_finala`
    FOREIGN KEY (`id_nota` )
    REFERENCES `disertatie`.`note` (`id_nota` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_stud_nota_finala`
    FOREIGN KEY (`id_student` )
    REFERENCES `disertatie`.`studenti` (`id_student` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `disertatie`.`prof_instdisc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `disertatie`.`prof_instdisc` ;

CREATE  TABLE IF NOT EXISTS `disertatie`.`prof_instdisc` (
  `id_profesor` INT(11) NOT NULL ,
  `id_instanta_disciplina` INT(11) NOT NULL ,
  PRIMARY KEY (`id_profesor`, `id_instanta_disciplina`) ,
  INDEX `id_profesor_pid_idx` (`id_profesor` ASC) ,
  INDEX `id_instdisc_pid_idx` (`id_instanta_disciplina` ASC) ,
  CONSTRAINT `id_instdisc_pid`
    FOREIGN KEY (`id_instanta_disciplina` )
    REFERENCES `disertatie`.`instanta_disciplina` (`id_instanta_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_profesor_pid`
    FOREIGN KEY (`id_profesor` )
    REFERENCES `disertatie`.`profesori` (`id_profesori` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `disertatie` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;