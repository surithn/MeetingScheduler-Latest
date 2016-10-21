--mysql --user root -p
show databases;

create database AZ;
use AZ;

Create table employee(
    e_id int(3) NOT NULL AUTO_INCREMENT, 
    e_name VARCHAR(100) NOT NULL, 
    primary key (e_id)
);

Create table attendants(
    a_id int(3) NOT NULL AUTO_INCREMENT, 
    a_name VARCHAR(100) NOT NULL, 
    primary key (a_id)
);

Create table rooms(
    r_id int(3) NOT NULL AUTO_INCREMENT, 
    r_name VARCHAR(100) NOT NULL, 
    primary key (r_id)
);

Create table location(
    l_id int(3) NOT NULL AUTO_INCREMENT, 
    l_name VARCHAR(100) NOT NULL, 
    primary key (l_id)
);

Create table meeting(
    m_id int(3) NOT NULL AUTO_INCREMENT, 
    start_time VARCHAR(100) not null,
	end_time VARCHAR(100) not null,
	m_name VARCHAR(100),
	primary key (m_id)
);

CREATE TABLE  met_att_junction (
  m_id int(3) NOT NULL,
  a_id int(3) NOT NULL,
  PRIMARY KEY (m_id, a_id),
  CONSTRAINT FK_a_id FOREIGN KEY (a_id) REFERENCES attendants (a_id),
  CONSTRAINT FK_m_id FOREIGN KEY (m_id) REFERENCES meeting (m_id)
);

CREATE TABLE  met_loc_junction (
  m_id int(3) NOT NULL,
  l_id int(3) NOT NULL,
  PRIMARY KEY (m_id, l_id),
  CONSTRAINT FK_l_id FOREIGN KEY (l_id) REFERENCES location (l_id),
  CONSTRAINT FK_m_l_id FOREIGN KEY (m_id) REFERENCES meeting (m_id)
);

insert into meeting values
(1, '10/18/16 10:04 PM', '10/18/16 10:04 PM', 'GIT'),
(2, '10/18/16 10:04 PM', '10/18/16 10:04 PM', 'Grunt'),
(3, '10/18/16 10:04 PM', '10/18/16 10:04 PM', 'Gradle');

insert into employee values
(1, 'surith'),
(2, 'gms'),
(3, 'arun'),
(4, 'subbu');

insert into attendants values
(1, 'surith'),
(2, 'gms'),
(3, 'arun'),
(4, 'subbu');

insert into rooms values
(1, 'Cauvery'),
(2, 'Yamuna'),
(3, 'Ganga'),
(4, 'Nile');

insert into location values
(1, 'Cauvery'),
(2, 'Yamuna'),
(3, 'Ganga'),
(4, 'Nile');

insert into met_att_junction values
(1, 1),
(1, 2),
(2, 3),
(3, 4);

insert into met_loc_junction values
(1, 1),
(1, 2),
(2, 3),
(3, 4);