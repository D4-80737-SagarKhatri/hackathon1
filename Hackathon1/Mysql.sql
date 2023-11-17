create table users (id int primary key AUTO_INCREMENT,
first_name varchar(40),
last_name varchar(40),
email varchar(40),
password varchar(40),
mobile varchar(10),
birth Date);

create table reviews(
id int primary key AUTO_INCREMENT,
movie_id int,
review varchar(40),
rating int,
user_id int,
modified timestamp,
foreign key (user_id) references users(id));

create table movies(
     id int primary key AUTO_INCREMENT,
    title varchar(40),
    releaseD Date);

create table shares(
review_id int,
 user_id int);

insert into movies values(default,"your name",'2016-08-26');
insert into movies values(default,"Inception",'2010-07-16');
insert into movies values(default,"back to the future",'1989-08-10');
insert into movies values(default,"power of inner voice",'2016-08-26');
insert into movies values(default,"jujutsu kaisen 0",'2021-12-24');
insert into movies values(default,"breaking bad",'2020-10-26');
insert into movies values(default,"naruto",'2000-03-16');
insert into movies values(default,"jab we met",'2005-08-26');
insert into movies values(default,"batman dark knights",'2012-08-02');
insert into movies values(default,"butterfly effect",'2004-02-06');
