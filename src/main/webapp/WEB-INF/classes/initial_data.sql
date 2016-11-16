/*initial insert of users table*/
insert into users (userid, password, name, email, active_flg, create_date, update_datetime) values ('admin', 'admin123', 'administrator', 'admin@gmail.com', 1,'2016-11-15', null);
insert into users (userid, password, name, email, active_flg, create_date, update_datetime) values ('user01', 'user01', 'user01', 'user01@gmail.com', 1,'2016-11-15', null);

/*initial insert of the parameter table*/
INSERT INTO parameter (parameter_id, parameter_name, parameter_varchar) VALUES ('1', 'description', 'This is the description of the online test.');
