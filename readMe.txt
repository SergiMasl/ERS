mysql> create table users(id_prof integer primary key AUTO_INCREMENT, userName char(50) UNIQUE , password char(50) UNIQUE);

 create table user(id_prof integer primary key AUTO_INCREMENT, userName char(50) UNIQUE , password char(50) UNIQUE, name char(50), email char(50) UNIQUE, adress char(50), phone char(50), accauntNubber char(50) UNIQUE, role char(50));