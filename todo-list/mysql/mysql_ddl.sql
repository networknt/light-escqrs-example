
USE event_sourcing;

DROP table IF EXISTS  TODO;



CREATE  TABLE TODO (
  ID varchar(255) PRIMARY KEY,
  TITLE varchar(255),
  COMPLETED BOOLEAN,
  ORDER_ID INTEGER,
  ACTIVE_FLG varchar(1) DEFAULT 'Y'
);
