create table films (
                       id bigint not null auto_increment,
                       film_id bigint not null,
                       rating float(53),
                       description varchar(255),
                       film_name varchar(255),
                       year int,
                       primary key (id)
);