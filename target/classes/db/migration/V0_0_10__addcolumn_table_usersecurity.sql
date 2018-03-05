ALTER  TABLE security.users
  ADD COLUMN nama_lengkap CHARACTER VARYING(25);

ALTER  TABLE security.users
  ADD COLUMN biodata TEXT;

ALTER TABLE security.users
  ALTER COLUMN nama_lengkap SET NOT NULL;