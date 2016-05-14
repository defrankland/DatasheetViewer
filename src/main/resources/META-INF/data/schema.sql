CREATE TABLE users (
  userId varchar(36) NOT NULL,
  email varchar(100) NOT NULL,
  password varchar(45) NOT NULL,
  username varchar(45) NOT NULL,
  enabled TINYINT NOT NULL,
  PRIMARY KEY (userId)
);

CREATE TABLE user_roles (
	  username varchar(45) NOT NULL,
	  role varchar(45) NOT NULL
);