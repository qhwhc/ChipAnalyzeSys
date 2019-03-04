/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/3/4 下午9:59:45                           */
/*==============================================================*/


drop table CHIP_DATA cascade constraints;

drop table CHIP_YIELD cascade constraints;

/*==============================================================*/
/* Table: CHIP_DATA                                             */
/*==============================================================*/
create table CHIP_DATA
(
   ID                   VARCHAR2(40)         not null,
   BATCH_NUMBER         VARCHAR2(40),
   PRODUCT_CODE         VARCHAR2(40),
   VERSION              VARCHAR2(20),
   NUMBER_PIECES        NUMBER(10),
   PROCESS_PERIOD       VARCHAR2(100),
   PROCESS              VARCHAR2(100),
   PROCESS_CONDITIONS   VARCHAR2(40),
   WORK_CENTER          VARCHAR2(20),
   WORK_UNIT            VARCHAR2(20),
   OPERATOR             VARCHAR2(20),
   START_TIME           VARCHAR2(40),
   END_TIME             VARCHAR2(40),
   constraint PK_CHIP_DATA primary key (ID)
);

comment on column CHIP_DATA.ID is
'ID';

comment on column CHIP_DATA.BATCH_NUMBER is
'批号';

comment on column CHIP_DATA.PRODUCT_CODE is
'产品编码';

comment on column CHIP_DATA.VERSION is
'版本';

comment on column CHIP_DATA.NUMBER_PIECES is
'数量';

comment on column CHIP_DATA.PROCESS_PERIOD is
'工序段';

comment on column CHIP_DATA.PROCESS is
'工序';

comment on column CHIP_DATA.PROCESS_CONDITIONS is
'工艺条件';

comment on column CHIP_DATA.WORK_CENTER is
'工作中心';

comment on column CHIP_DATA.WORK_UNIT is
'作业单元';

comment on column CHIP_DATA.OPERATOR is
'操作人';

comment on column CHIP_DATA.START_TIME is
'当道开始时间';

comment on column CHIP_DATA.END_TIME is
'当道结束时间';

/*==============================================================*/
/* Table: CHIP_YIELD                                            */
/*==============================================================*/
create table CHIP_YIELD
(
   ID                   VARCHAR2(40)         not null,
   BATCH_NUMBERBATCH_NUMBER VARCHAR2(40),
   NUMBER_PIECES        NUMBER(10),
   PARTICLES            NUMBER(10),
   YIELD                NUMBER(10,2),
   constraint PK_CHIP_YIELD primary key (ID)
);

comment on column CHIP_YIELD.ID is
'ID';

comment on column CHIP_YIELD.BATCH_NUMBERBATCH_NUMBER is
'批号';

comment on column CHIP_YIELD.NUMBER_PIECES is
'片数';

comment on column CHIP_YIELD.PARTICLES is
'颗粒数';

comment on column CHIP_YIELD.YIELD is
'良率';

