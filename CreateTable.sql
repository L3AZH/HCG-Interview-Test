-- CREATE ENTITY--
CREATE DATABASE bookingsystemdb;
USE bookingsystemdb;
CREATE TABLE IF NOT EXISTS `hotel` (
    `id` INT UNSIGNED AUTO_INCREMENT,
    `name` NVARCHAR(255),
    PRIMARY KEY (`id`)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `room_type` (
    `id` INT UNSIGNED AUTO_INCREMENT,
    `name` NVARCHAR(255),
    PRIMARY KEY (`id`)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `rate_plan` (
    `id` INT UNSIGNED AUTO_INCREMENT,
    `name` NVARCHAR(255),
    PRIMARY KEY (`id`)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `period` (
    `id` INT UNSIGNED AUTO_INCREMENT,
    `start_date` DATETIME NOT NULL,
    `end_date` DATETIME,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `room_rate` (
    `room_type_id` INT UNSIGNED,
    `date` DATE,
    `price` DECIMAL(20 , 2 ),
    `default_rate_plan` INT UNSIGNED,
    PRIMARY KEY (`room_type_id` , `date`),
    FOREIGN KEY (`room_type_id`)
        REFERENCES room_type (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (`default_rate_plan`)
        REFERENCES rate_plan (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `room_availability` (
    `room_type_id` INT UNSIGNED,
    `date` DATE,
    `available_to_sell` INT,
    PRIMARY KEY (`room_type_id` , `date`),
    FOREIGN KEY (`room_type_id`)
        REFERENCES room_type (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `guest` (
    `email` NVARCHAR(255),
    `phone_number` NVARCHAR(30),
    PRIMARY KEY (`email`)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `booking` (
    `id` INT UNSIGNED AUTO_INCREMENT,
    `guest_email` NVARCHAR(255),
    `price` DECIMAL(20 , 2 ),
    `room_type_id` INT UNSIGNED,
    `rate_plan_id` INT UNSIGNED,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`guest_email`)
        REFERENCES guest (`email`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (`room_type_id`)
        REFERENCES room_type (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (`rate_plan_id`)
        REFERENCES rate_plan (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT
)  ENGINE=INNODB;

-- CREATE RELATIONSHIP--

CREATE TABLE IF NOT EXISTS `hotel_rel_room_type` (
    `hotel_id` INT UNSIGNED,
    `room_type_id` INT UNSIGNED,
    PRIMARY KEY (`hotel_id` , `room_type_id`),
    FOREIGN KEY (`hotel_id`)
        REFERENCES hotel (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (`room_type_id`)
        REFERENCES room_type (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `hotel_rel_rate_plan` (
    `hotel_id` INT UNSIGNED,
    `rate_plan_id` INT UNSIGNED,
    PRIMARY KEY (`hotel_id` , `rate_plan_id`),
    FOREIGN KEY (`hotel_id`)
        REFERENCES hotel (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (`rate_plan_id`)
        REFERENCES rate_plan (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `period_rel_rate_plan` (
    `period_id` INT UNSIGNED,
    `rate_plan_id` INT UNSIGNED,
    PRIMARY KEY (`period_id` , `rate_plan_id`),
    FOREIGN KEY (`period_id`)
        REFERENCES period (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (`rate_plan_id`)
        REFERENCES rate_plan (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS `room_type_rel_rate_plan`(
    `room_type_id` INT UNSIGNED,
    `rate_plan_id` INT UNSIGNED,
    PRIMARY KEY (`room_type_id`,`rate_plan_id`),
    FOREIGN KEY (`room_type_id`)
        REFERENCES room_type(`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (`rate_plan_id`)
        REFERENCES rate_plan (`id`)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=INNODB;