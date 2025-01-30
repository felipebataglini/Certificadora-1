-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bfm
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bfm
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bfm` DEFAULT CHARACTER SET utf8 ;
USE `bfm` ;

-- -----------------------------------------------------
-- Table `bfm`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfm`.`administrador` (
  `adm_id` INT NOT NULL,
  `adm_cpf` BIGINT(11) NOT NULL,
  `adm_nome` VARCHAR(90) NOT NULL,
  `adm_telefone` BIGINT(11) NOT NULL,
  `adm_cargo` VARCHAR(45) NOT NULL,
  `adm_email` VARCHAR(90) NOT NULL,
  `adm_senha` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`adm_id`),
  UNIQUE INDEX `adm_email_UNIQUE` (`adm_email` ASC) VISIBLE,
  UNIQUE INDEX `adm_cpf_UNIQUE` (`adm_cpf` ASC) VISIBLE,
  UNIQUE INDEX `adm_telefone_UNIQUE` (`adm_telefone` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bfm`.`voluntario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfm`.`voluntario` (
  `vol_id` INT NOT NULL,
  `vol_cpf` BIGINT(11) NOT NULL,
  `vol_nome` VARCHAR(90) NOT NULL,
  `vol_telefone` BIGINT(11) NOT NULL,
  `vol_email` VARCHAR(90) NOT NULL,
  `vol_senha` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`vol_id`),
  UNIQUE INDEX `vol_cpf_UNIQUE` (`vol_cpf` ASC) VISIBLE,
  UNIQUE INDEX `vol_email_UNIQUE` (`vol_email` ASC) VISIBLE,
  UNIQUE INDEX `vol_telefone_UNIQUE` (`vol_telefone` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bfm`.`escola`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfm`.`escola` (
  `esc_id` INT NOT NULL,
  `esc_nome` VARCHAR(90) NOT NULL,
  `esc_endereco` VARCHAR(90) NOT NULL,
  `esc_responsavel` VARCHAR(90) NOT NULL,
  `esc_email` VARCHAR(90) NOT NULL,
  `esc_telefone` BIGINT(11) NOT NULL,
  PRIMARY KEY (`esc_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bfm`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfm`.`produto` (
  `pro_id` INT NOT NULL,
  `pro_nome` VARCHAR(45) NOT NULL,
  `pro_marca` VARCHAR(45) NOT NULL,
  `pro_tipo` VARCHAR(45) NULL,
  `pro_quantidade` INT NOT NULL,
  PRIMARY KEY (`pro_id`),
  UNIQUE INDEX `pro_tipo_UNIQUE` (`pro_nome` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bfm`.`doacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bfm`.`doacao` (
  `doa_id` INT NOT NULL,
  `doa_data` DATE NOT NULL,
  `esc_id` INT NOT NULL,
  `vol_id` INT NOT NULL,
  `pro_id` INT NOT NULL,
  PRIMARY KEY (`doa_id`),
  INDEX `fk_doacao_escola_idx` (`esc_id` ASC) VISIBLE,
  INDEX `fk_doacao_voluntario1_idx` (`vol_id` ASC) VISIBLE,
  INDEX `fk_doacaosaida_produto1_idx` (`pro_id` ASC) VISIBLE,
  CONSTRAINT `fk_doacao_escola`
    FOREIGN KEY (`esc_id`)
    REFERENCES `bfm`.`escola` (`esc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_doacao_voluntario1`
    FOREIGN KEY (`vol_id`)
    REFERENCES `bfm`.`voluntario` (`vol_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_doacaosaida_produto1`
    FOREIGN KEY (`pro_id`)
    REFERENCES `bfm`.`produto` (`pro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
