SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `jpatest` ;
CREATE SCHEMA IF NOT EXISTS `jpatest` DEFAULT CHARACTER SET utf8 ;
USE `jpatest` ;

-- -----------------------------------------------------
-- Table `jpatest`.`an_universitar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`an_universitar` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`an_universitar` (
  `id_an_universitar` INT(11) NOT NULL ,
  `an_universitar` INT(11) NOT NULL ,
  `tip_an_universitar` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`id_an_universitar`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`ciclu_studiu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`ciclu_studiu` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`ciclu_studiu` (
  `id_ciclu_studiu` INT(11) NOT NULL ,
  `tip_ciclu_studiu` CHAR(10) NOT NULL ,
  PRIMARY KEY (`id_ciclu_studiu`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`an_studiu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`an_studiu` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`an_studiu` (
  `id_an_studiu` INT(11) NOT NULL ,
  `an_studiu` INT(11) NOT NULL ,
  `id_ciclu_studiu` INT(11) NOT NULL ,
  `data_inceput` DATE NOT NULL ,
  `data_sfarsit` DATE NOT NULL ,
  `id_an_universitar` INT(11) NOT NULL ,
  PRIMARY KEY (`id_an_studiu`) ,
  INDEX `id_ciclu_studiu_idx` (`id_ciclu_studiu` ASC) ,
  INDEX `id_an_univ_anstd_idx` (`id_an_universitar` ASC) ,
  CONSTRAINT `id_an_univ_anstd`
    FOREIGN KEY (`id_an_universitar` )
    REFERENCES `jpatest`.`an_universitar` (`id_an_universitar` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_ciclu_studiu`
    FOREIGN KEY (`id_ciclu_studiu` )
    REFERENCES `jpatest`.`ciclu_studiu` (`id_ciclu_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`discipline_general`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`discipline_general` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`discipline_general` (
  `id_disciplina` INT(11) NOT NULL ,
  `nume` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_disciplina`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`tip_persoane`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`tip_persoane` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`tip_persoane` (
  `id_tip_persoane` INT(11) NOT NULL ,
  `tip_persoane` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`id_tip_persoane`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`persoane`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`persoane` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`persoane` (
  `id_persoana` INT(11) NOT NULL ,
  `id_tip_persoana` INT(11) NOT NULL ,
  `nume_persoana` VARCHAR(45) NOT NULL ,
  `prenume_persoana` VARCHAR(45) NOT NULL ,
  `adresa` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_persoana`) ,
  INDEX `id_tip_persoana_idx` (`id_tip_persoana` ASC) ,
  CONSTRAINT `id_tip_persoana`
    FOREIGN KEY (`id_tip_persoana` )
    REFERENCES `jpatest`.`tip_persoane` (`id_tip_persoane` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`profesori`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`profesori` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`profesori` (
  `id_profesori` INT(11) NOT NULL ,
  `id_persoana` INT(11) NOT NULL ,
  PRIMARY KEY (`id_profesori`) ,
  INDEX `id_persoana_idx` (`id_persoana` ASC) ,
  CONSTRAINT `id_persoana_prof`
    FOREIGN KEY (`id_persoana` )
    REFERENCES `jpatest`.`persoane` (`id_persoana` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`studenti`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`studenti` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`studenti` (
  `id_student` INT(11) NOT NULL ,
  `nr_matricol` VARCHAR(8) NOT NULL ,
  `id_persoana` INT(11) NOT NULL ,
  PRIMARY KEY (`id_student`) ,
  INDEX `id_persoana_idx` (`id_persoana` ASC) ,
  CONSTRAINT `id_persoana_stud`
    FOREIGN KEY (`id_persoana` )
    REFERENCES `jpatest`.`persoane` (`id_persoana` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`instanta_disciplina`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`instanta_disciplina` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`instanta_disciplina` (
  `id_instanta_disciplina` INT(11) NOT NULL ,
  `id_disciplina` INT(11) NOT NULL ,
  `id_an_studiu` INT(11) NOT NULL ,
  `id_profesor` INT(11) NOT NULL ,
  `id_an_universitar` INT(11) NOT NULL ,
  `numar_credite` INT(2) NOT NULL ,
  `semestru` INT(11) NOT NULL ,
  `id_student` INT(11) NOT NULL ,
  `factor_k` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_instanta_disciplina`) ,
  INDEX `id_disciplina_id_idx` (`id_disciplina` ASC) ,
  INDEX `id_profesor_id_idx` (`id_profesor` ASC) ,
  INDEX `id_an_univ_id_idx` (`id_an_universitar` ASC) ,
  INDEX `id_student_id_idx` (`id_student` ASC) ,
  INDEX `id_an_studiu_id_idx` (`id_an_studiu` ASC) ,
  CONSTRAINT `id_an_univ_id`
    FOREIGN KEY (`id_an_universitar` )
    REFERENCES `jpatest`.`an_universitar` (`id_an_universitar` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_disciplina_id`
    FOREIGN KEY (`id_disciplina` )
    REFERENCES `jpatest`.`discipline_general` (`id_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_profesor_id`
    FOREIGN KEY (`id_profesor` )
    REFERENCES `jpatest`.`profesori` (`id_profesori` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_student_id`
    FOREIGN KEY (`id_student` )
    REFERENCES `jpatest`.`studenti` (`id_student` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_an_studiu_id`
    FOREIGN KEY (`id_an_studiu` )
    REFERENCES `jpatest`.`an_studiu` (`id_an_studiu` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`note`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`note` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`note` (
  `id_nota` INT(11) NOT NULL ,
  `tip_nota` CHAR(15) NOT NULL ,
  PRIMARY KEY (`id_nota`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`note_activitate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`note_activitate` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`note_activitate` (
  `id_nota_activitate` INT(11) NOT NULL ,
  `id_nota` INT(11) NOT NULL ,
  `data` DATE NULL DEFAULT NULL ,
  `id_student` INT(11) NOT NULL ,
  `id_instanta_disciplina` INT(11) NOT NULL ,
  `nota` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_nota_activitate`) ,
  INDEX `id_stud_nota_activ_idx` (`id_student` ASC) ,
  INDEX `id_inst_disciplina_nactiv_idx` (`id_instanta_disciplina` ASC) ,
  INDEX `id_nota_activitate_idx` (`id_nota` ASC) ,
  CONSTRAINT `id_inst_disciplina_nactiv`
    FOREIGN KEY (`id_instanta_disciplina` )
    REFERENCES `jpatest`.`instanta_disciplina` (`id_instanta_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_nota_activitate`
    FOREIGN KEY (`id_nota` )
    REFERENCES `jpatest`.`note` (`id_nota` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_stud_nota_activ`
    FOREIGN KEY (`id_student` )
    REFERENCES `jpatest`.`studenti` (`id_student` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`note_examen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`note_examen` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`note_examen` (
  `id_nota_examen` INT(11) NOT NULL ,
  `id_nota` INT(11) NOT NULL ,
  `data` DATETIME NULL DEFAULT NULL ,
  `id_student` INT(11) NOT NULL ,
  `id_instanta_disciplina` INT(11) NOT NULL ,
  `nota` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_nota_examen`) ,
  INDEX `id_nota_examen_idx` (`id_nota` ASC) ,
  INDEX `id_stud_nota_exam_idx` (`id_student` ASC) ,
  INDEX `id_inst_disciplina_nexam_idx` (`id_instanta_disciplina` ASC) ,
  CONSTRAINT `id_inst_disciplina_nexam`
    FOREIGN KEY (`id_instanta_disciplina` )
    REFERENCES `jpatest`.`instanta_disciplina` (`id_instanta_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_nota_examen`
    FOREIGN KEY (`id_nota` )
    REFERENCES `jpatest`.`note` (`id_nota` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_stud_nota_exam`
    FOREIGN KEY (`id_student` )
    REFERENCES `jpatest`.`studenti` (`id_student` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`note_finale`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`note_finale` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`note_finale` (
  `id_nota_finala` INT(11) NOT NULL ,
  `id_nota` INT(11) NOT NULL ,
  `data` DATETIME NULL DEFAULT NULL ,
  `id_student` INT(11) NOT NULL ,
  `id_instanta_disciplina` INT(11) NOT NULL ,
  `nota_examen` FLOAT NULL DEFAULT NULL ,
  `nota_activitate` FLOAT NULL DEFAULT NULL ,
  `medie_finala` FLOAT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_nota_finala`) ,
  INDEX `id_nota_finala_idx` (`id_nota` ASC) ,
  INDEX `id_stud_nota_finala_idx` (`id_student` ASC) ,
  INDEX `id_inst_disciplina_nfinala_idx` (`id_instanta_disciplina` ASC) ,
  CONSTRAINT `id_inst_disciplina_nfinala`
    FOREIGN KEY (`id_instanta_disciplina` )
    REFERENCES `jpatest`.`instanta_disciplina` (`id_instanta_disciplina` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_nota_finala`
    FOREIGN KEY (`id_nota` )
    REFERENCES `jpatest`.`note` (`id_nota` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_stud_nota_finala`
    FOREIGN KEY (`id_student` )
    REFERENCES `jpatest`.`studenti` (`id_student` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `jpatest`.`perioada_semestru`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`perioada_semestru` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`perioada_semestru` (
  `id_perioada_sem` INT(11) NOT NULL ,
  `numar_semestru` INT(1) NOT NULL ,
  `id_an_studiu` INT(11) NOT NULL ,
  `data_inceput` DATE NOT NULL ,
  `data_sfarsit` DATE NOT NULL ,
  PRIMARY KEY (`id_perioada_sem`) ,
  INDEX `id_an_studiu_persem_idx` (`id_an_studiu` ASC) ,
  CONSTRAINT `id_an_studiu_persem`
    FOREIGN KEY (`id_an_studiu` )
    REFERENCES `jpatest`.`an_studiu` (`id_an_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `jpatest`.`programe_studiu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jpatest`.`programe_studiu` ;

CREATE  TABLE IF NOT EXISTS `jpatest`.`programe_studiu` (
  `id_programe_studiu` INT(11) NOT NULL ,
  `detaliu_program_studiu` VARCHAR(15) NOT NULL ,
  `id_ciclu_studiu` INT(11) NOT NULL ,
  PRIMARY KEY (`id_programe_studiu`) ,
  INDEX `id_ciclu_studiu_prgstd_idx` (`id_ciclu_studiu` ASC) ,
  CONSTRAINT `id_ciclu_studiu_prgstd`
    FOREIGN KEY (`id_ciclu_studiu` )
    REFERENCES `jpatest`.`ciclu_studiu` (`id_ciclu_studiu` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `jpatest` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
