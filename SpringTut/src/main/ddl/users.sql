
create table USERS (
  username varchar2(256) not null PRIMARY KEY,
  password varchar2(256) not null,
  enabled number(1) not null
);
create table AUTHORITIES (
  username varchar2(256) not null,
  authority VARCHAR2(50) not null,
  FOREIGN KEY (username) REFERENCES USERS (username)
);

create UNIQUE index AUTHORITIES_IDX on AUTHORITIES(username, authority) ;

insert into USERS(user_id, username, password, email, enabled) VALUES (USER_ID_SEQ.nextval, 'ADMIN', 'ADMIN', 'ADMIN@ADMIN.ADMIN', 1);
insert into AUTHORITIES(AUTHORITY_ID, AUTHORITY) VALUES  (AUTHORITY_ID_SEQ.nextval, 'ADMIN');


commit;