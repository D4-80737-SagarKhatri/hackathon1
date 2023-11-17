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
