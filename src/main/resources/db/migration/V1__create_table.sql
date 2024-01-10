create table films (
                       rating float(53),
                       film_id bigint not null auto_increment,
                       description varchar(255),
                       film_name varchar(255),
                       year int,
                       primary key (film_id)
);