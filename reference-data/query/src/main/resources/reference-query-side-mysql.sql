DROP table IF EXISTS REFERENCE_QUERY_LIST;

CREATE  TABLE REFERENCE_QUERY_LIST (
  ID varchar(255) PRIMARY KEY,
  REFERENCE_NAME varchar(255),
  DESCRIPTION varchar(255),
  STATUS varchar(1),
  ACTIVE_FLG varchar(1) DEFAULT 'Y'
);
