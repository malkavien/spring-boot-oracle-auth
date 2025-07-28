CREATE OR REPLACE PROCEDURE CREATE_USER_PROC(
    p_username IN VARCHAR2,
    p_password IN VARCHAR2,
    p_role IN VARCHAR2
) AS
BEGIN
    INSERT INTO users (username, password, role) VALUES (p_username, p_password, p_role);
END;
/