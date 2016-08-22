BEGIN
  FOR i IN 1 .. 5
  LOOP
    FOR RR IN
    (
    SELECT 'drop '
           || object_type
           || ' '
           || object_name STM
    FROM
      SYS.USER_OBJECTS
    )
    LOOP
      BEGIN
        EXECUTE IMMEDIATE RR.STM;
        EXCEPTION
        WHEN OTHERS THEN
        NULL;
      END;
    END LOOP;
  END LOOP;
END;
