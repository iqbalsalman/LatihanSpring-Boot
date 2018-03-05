CREATE SCHEMA security;

CREATE SEQUENCE role_seq
  START 1
  INCREMENT 1;

CREATE TABLE security.roles (
  role_id      int8 PRIMARY KEY   NOT NULL DEFAULT nextval('role_seq'),
  rolename     CHARACTER VARYING(20) NOT NULL UNIQUE,
  created_by   CHARACTER VARYING(50),
  created_date TIMESTAMP             NOT NULL
);

CREATE TABLE security.users (
  user_id      CHARACTER VARYING(64)  NOT NULL PRIMARY KEY,
  username     CHARACTER VARYING(150) NOT NULL UNIQUE,
  passwd       CHARACTER VARYING(255) NOT NULL,
  is_active    BOOLEAN                NOT NULL,
  created_by   CHARACTER VARYING(50),
  created_date TIMESTAMP              NOT NULL
);

CREATE TABLE security.user_roles (
  user_id CHARACTER VARYING(64) NOT NULL REFERENCES security.users (user_id),
  role_id int8               NOT NULL REFERENCES security.roles (role_id)
);