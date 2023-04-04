create table IF NOT EXISTS employers (
                       id serial not null constraint app_user_pkey primary key,
                       firstName varchar(30) not null ,
                       lastName varchar(30) not null ,
                       email varchar(155) not null ,
                       password varchar(155) not null ,
                       birthdate varchar(155) not null

);

create table IF NOT EXISTS job (
                       id serial not null constraint app_job_pkey primary key,
                       title varchar(30) not null ,
                       description varchar(30) not null ,
                       status int not null,
                       CONSTRAINT fk_skill
                        FOREIGN KEY(skill_id)
                        REFERENCES skill(id)
);

create table IF NOT EXISTS skills (
                       id serial not null constraint app_skill_pkey primary key,
                       skill varchar(30) not null
);

create table IF NOT EXISTS job_skills (
                       skill_id int not null,
                       job_skill int not null
);