

declare
  L_RET_USER_ID number;
  L_USER_ROLE number;
  L_ADMIN_ROLE number;
  L_ADMIN_ID number;
BEGIN

  INSERT INTO USERS (user_id, username, password, email, enabled) VALUES (USER_ID_SEQ.nextval, 'ADMIN', 'ADMIN', 'ADMIN@ADMIN.ADMIN', 1) returning user_id into L_ADMIN_ID;
  INSERT INTO AUTHORITIES (AUTHORITY_ID, AUTHORITY) VALUES (AUTHORITY_ID_SEQ.nextval, 'ADMIN') returning AUTHORITY_ID into L_ADMIN_ROLE;
  INSERT INTO AUTHORITIES (AUTHORITY_ID, AUTHORITY) VALUES (AUTHORITY_ID_SEQ.nextval, 'USER') returning AUTHORITY_ID into L_USER_ROLE;

  INSERT INTO USER_AUTHORITIES (user_id, authority_id) VALUES (L_ADMIN_ID, L_ADMIN_ROLE);

  INSERT INTO USER_AUTHORITIES (user_id, authority_id) VALUES (L_ADMIN_ID, L_USER_ROLE);

for i in 1 .. 10
  loop
    INSERT INTO USERS (user_id, username, password, email, enabled)
    VALUES (USER_ID_SEQ.nextval, 'USER-' || i, 'user-' || i, 'user'|| i ||'@test.com', 1)
    RETURNING USER_ID INTO L_RET_USER_ID;

INSERT INTO USER_AUTHORITIES (user_id, authority_id) VALUES (
  L_RET_USER_ID,
    L_USER_ROLE
);
end loop;
commit;
END;
