create table SCENARIO_TYPE_SCHEMA_1 (
  SCENARIO_ID number not null,
  SCENARIO_XML xmltype,
  CONSTRAINT SCENARIO_TYPE_SCHEMA_1_PK
    PRIMARY KEY(SCENARIO_ID),
  CONSTRAINT SCENARIO_TYPE_1_SCENARIO_FK1
    FOREIGN KEY(SCENARIO_ID)
    REFERENCES SCENARIO_TYPE_PARENT(SCENARIO_ID)
    ON DELETE CASCADE
  )
  xmltype SCENARIO_XML store as object relational
  xmlschema "scenarios.xsd"
  ELEMENT "scenarios";