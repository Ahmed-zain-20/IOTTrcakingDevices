# IOTTrcakingDevices



1- create IOT_DEVICES table in HR Schema orcale XE DB
   create trigger and sequence in DEVICE_ID column
   create unique constrain in DEVICE_PIN  column
   DEVICE_STATUS   DEFAULT 'READY',
   TEMPERATURE     DEFAULT 1 
  
script :

DROP TABLE HR.IOT_DEVICES CASCADE CONSTRAINTS;

CREATE TABLE HR.IOT_DEVICES
(
  DEVICE_ID      NUMBER                         NOT NULL,
  DEVICE_NAME    VARCHAR2(50 BYTE),
  DEVICE_PIN     NUMBER                         NOT NULL,
  DEVICE_STATUS  VARCHAR2(10 BYTE)              DEFAULT 'READY',
  TEMPERATURE    NUMBER                         DEFAULT 1
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
MONITORING;


CREATE UNIQUE INDEX HR.IOT_DEVICES_PK ON HR.IOT_DEVICES
(DEVICE_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           );
CREATE UNIQUE INDEX HR.UNIQE_PIN ON HR.IOT_DEVICES
(DEVICE_PIN)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           );

ALTER TABLE HR.IOT_DEVICES ADD (
  CONSTRAINT IOT_DEVICES_PK
  PRIMARY KEY
  (DEVICE_ID)
  USING INDEX HR.IOT_DEVICES_PK
  ENABLE VALIDATE
,  CONSTRAINT UNIQE_PIN
  UNIQUE (DEVICE_PIN)
  USING INDEX HR.UNIQE_PIN
  ENABLE VALIDATE);


DROP SEQUENCE HR.IOT_DEVICES_SEQ;

CREATE SEQUENCE HR.IOT_DEVICES_SEQ
  START WITH 21
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 20
  NOORDER;



/


------------------------------------------------
There is a collection uploaded for all requests.

