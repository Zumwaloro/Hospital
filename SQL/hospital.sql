CREATE DATABASE hospital;
USE hospital;

CREATE TABLE patient (
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
date_of_birth DATE NOT NULL,
personal_number CHAR(11) NOT NULL PRIMARY KEY,
gender ENUM('M', 'F') NOT NULL,
department VARCHAR(50) NOT NULL,
diagnosis VARCHAR(50) NOT NULL);

CREATE TABLE staff (
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
date_of_birth DATE NOT NULL,
personal_number CHAR(11) NOT NULL PRIMARY KEY,
gender ENUM('M', 'F') NOT NULL,
monthly_salary MEDIUMINT UNSIGNED NOT NULL,
role VARCHAR(30) NOT NULL,
department VARCHAR(30));

CREATE TABLE department (
department_name VARCHAR(50) NOT NULL PRIMARY KEY,
nr_of_bedrooms TINYINT NOT NULL);

CREATE TABLE activity (
activity VARCHAR(30) NOT NULL,
act_date DATE NOT NULL,
act_time MEDIUMINT UNSIGNED NOT NULL,
actor_name VARCHAR(60) NOT NULL,
PRIMARY KEY(act_date, actor_name));

INSERT INTO staff VALUE
('Teresa', 'Browder', '1977-05-17', '17057782936', 'F', 42000, 'Specialist', 'Pulmonology'),
('William', 'Dunn', '1985-12-12', '12128531974', 'M', 35000, 'Nurse', 'Pulmonology'),
('Linda', 'Brandt', '1993-10-03', '03109352871', 'F', 25000, 'Administrator', 'Cardiology'),
('Chad', 'Dias', '1980-03-14', '03148073912', 'M', 42000, 'Specialist', 'Cardiology'),
('Michael', 'Douglass', '1979-05-02', '02057935710', 'M', 50000, 'Specialist', 'Gastroenterology'),
('Samira', 'Walter', '1997-06-08', '08069752732', 'F', 38000, 'Nurse', 'Gastroenterology'),
('Betty', 'Ware', '1971-05-10', '10057120756', 'F', 47000, 'Specialist','Traumatology'),
('Dorian', 'Sellers', '1986-11-12', '12118605463', 'M', 35000, 'Nurse', 'Traumatology');

INSERT INTO department VALUE
('Pulmonology', 10),
('Cardiology', 15),
('Gastroenterology', 5),
('Traumatology', 20);

INSERT INTO patient VALUE
('Anthony', 'Bower', '1945-05-12', '12051945357', 'M', 'Pulmonology', 'Carcinoma Pulmonum'),
('Billy', 'Frazier', '1987-12-03', '03128754220', 'M', 'Pulmonology', 'Hydrocephalus Puerperalis'),
('Rebecca', 'Hammond', '1995-07-20', '20079519374', 'F', 'Pulmonology', 'Infectio Acerbus'),
('Winston', 'Roe', '1963-09-01', '01096320675', 'M', 'Pulmonology', 'Chorea Spissus'),
('Fern', 'Collins', '1989-11-25', '25118769047', 'M', 'Cardiology', 'Dotuses Carnus'),
('Eddie', 'Suggs', '1999-10-15', '15109940716', 'M', 'Cardiology', 'Virisma Conturis'),
('Sue', 'Roberts', '2000-02-06', '06020019263', 'F', 'Cardiology', 'Fihagia Intesrhus'),
('Lawrence', 'Bauder', '2008-08-08', '08080854132', 'M', 'Gastroenterology', 'Mollicrum Gelaties'),
('Charles', 'Keene', '2010-04-11', '11041008764', 'M', 'Gastroenterology', 'Angiture Abscerea'),
('Jean', 'Lindsey', '2005-03-12', '12030514785', 'F', 'Gastroenterology', 'Ambustio Pedicularis'),
('Myra', 'Franco', '2002-01-10', '10010235795', 'F', 'Gastroenterology', 'Fracture Spissus'),
('James', 'Calvillo', '1955-05-18', '18055532189', 'M', 'Gastroenterology', 'Peritus Punctum'),
('Lisa', 'Bennett', '1997-07-11', '11079782645', 'F', 'Traumatology', 'Atrophia Cerebri'),
('Erika', 'Moniz', '1966-08-08', '08086654673', 'F', 'Traumatology', 'Hydropisis Puerperalis');
