CREATE DATABASE IF NOT EXISTS leaves_db;
USE leaves_db;

CREATE TABLE IF NOT EXISTS leaves (
	leave_id int(10) unsigned NOT NULL AUTO_INCREMENT,
	employee_id int(10) NOT NULL,
	leave_type int(2) NOT NULL,
	number_of_days int(2) NOT NULL,
	start_date DATE,
	end_date DATE,
	requested_date DATE,
	modified_date DATE,
  PRIMARY KEY (leave_id)
);


INSERT INTO `leaves_db`.`leaves` (`employee_id`, `leave_type`, `number_of_days`, `start_date`, `end_date`, `requested_date`, `modified_date`) VALUES ('1', '1', '1', '2022-06-26', '2022-06-26', '2022-06-25', '2022-06-25');

INSERT INTO `leaves_db`.`leaves` (`employee_id`, `leave_type`, `number_of_days`, `start_date`, `end_date`, `requested_date`, `modified_date`) VALUES ('1', '1', '2', '2022-06-04', '2022-06-06', '2022-05-06', '2022-05-06');
INSERT INTO `leaves_db`.`leaves` (`employee_id`, `leave_type`, `number_of_days`, `start_date`, `end_date`, `requested_date`, `modified_date`) VALUES ('1', '2', '2', '2022-05-04', '2022-05-05', '2022-05-06', '2022-05-06');

commit;

