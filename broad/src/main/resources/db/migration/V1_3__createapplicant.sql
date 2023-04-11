create table IF NOT EXISTS applicants (
                       id serial not null constraint app_applicant_pkey primary key,
                       name varchar(30) not null ,
                       email varchar(155) not null ,
                       age int not null,
                       address varchar(155) not null,
                       educationDetails varchar(155) not null,
                       skills varchar(155) not null,
                       user_id int not null,
                       CONSTRAINT fk_user
                       FOREIGN KEY(user_id)
                        REFERENCES users(id)

);
