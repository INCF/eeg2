CREATE TABLE "SCENARIO_TYPE_NONXML" (
  "SCENARIO_ID" NUMBER NOT NULL ENABLE, 
	"SCENARIO_XML" BLOB, 
  CONSTRAINT "SCENARIO_TABLE_NONXML_PK"
    PRIMARY KEY ("SCENARIO_ID"), 
  CONSTRAINT "SCENARIO_TYPE_NONXML_SCEN_FK1"
    FOREIGN KEY ("SCENARIO_ID")
	  REFERENCES "SCENARIO_TYPE_PARENT" ("SCENARIO_ID")
    ON DELETE CASCADE ENABLE
  )
  LOB ("SCENARIO_XML") STORE AS BASICFILE;