# --- First database schema

# --- !Ups

create table company (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table computer (
  id                        bigint not null,
  name                      varchar(255),
  introduced                timestamp,
  discontinued              timestamp,
  company_id                bigint,
  constraint pk_computer primary key (id))
;
create table ram (
  id                        bigint not null,
  descripcion                      varchar(255),
  capacidad                integer,
  velocidad              integer,
  computer_id                bigint,
  constraint pk_ram primary key (id))
;

create sequence company_seq start with 1000;

create sequence computer_seq start with 1000;

create sequence ram_seq start with 1000;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);

alter table computer add constraint fk_computer_ram_1 foreign key (ram_id) references ram (id) on delete restrict on update restrict;
create index ix_computer_ram_1 on computer (ram_id);

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;

drop table if exists computer;

drop table if exists ram;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists computer_seq;

drop sequence if exists ram_seq;

