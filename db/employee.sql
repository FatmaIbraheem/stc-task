CREATE DATABASE IF NOT EXISTS employee_db;
USE employee_db;

CREATE TABLE IF NOT EXISTS employee (
	employee_id int(10) unsigned NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	phone varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	max_paid_leaves int(2),
	left_paid_leaves int(2),
	taken_paid_leaves int(2),
	taken_unpaid_leaves int(2),
  PRIMARY KEY (employee_id)
);


INSERT INTO `employee_db`.`employee` (`name`, `phone`, `email`, `max_paid_leaves`, `left_paid_leaves`, `taken_paid_leaves`, `taken_unpaid_leaves`) VALUES ('emp1', '01011111111', 'emp1@test.com', '21', '19', '3', '2');
INSERT INTO `employee_db`.`employee` (`name`, `phone`, `email`, `max_paid_leaves`, `left_paid_leaves`, `taken_paid_leaves`, `taken_unpaid_leaves`) VALUES ('emp2', '01022222222', 'emp2@test.com', '21', '21', '0', '0');

commit;

