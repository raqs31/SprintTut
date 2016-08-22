BEGIN
  FOR i IN 1 .. 5
  LOOP
    FOR R IN
    (
    SELECT 'drop '
           || object_type
           || ' '
           || object_name
           || ';' stm
    FROM
      SYS.USER_OBJECTS
    )
    LOOP
      EXECUTE IMMEDIATE R.STM;
    END LOOP;
  END LOOP;
END;
