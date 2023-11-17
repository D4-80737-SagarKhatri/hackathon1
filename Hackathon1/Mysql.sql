create table users (id int primary key,
first_name varchar(40),
last_name varchar(40),
email varchar(40),
password varchar(40),
mobile varchar(10),
birth Date);

create table reviews(
id int primary key,
movie_id int,
review varchar(40),
rating int,
user_id int,
modified timestamp,
foreign key (user_id) references users(id));

create table movies(
     id int primary key,
    title varchar(40),
    releaseD Date);

create table shares(
review_id int,
 user_id int);

insert into movies values(1,"your name",'2016-08-26');
insert into movies values(2,"Inception",'2010-07-16');
insert into movies values(3,"back to the future",'1989-08-10');
insert into movies values(4,"power of inner voice",'2016-08-26');
insert into movies values(5,"jujutsu kaisen 0",'2021-12-24');
insert into movies values(6,"breaking bad",'2020-10-26');
insert into movies values(7,"naruto",'2000-03-16');
insert into movies values(8,"jab we met",'2005-08-26');
insert into movies values(9,"batman dark knights",'2012-08-02');
insert into movies values(10,"butterfly effect",'2004-02-06');