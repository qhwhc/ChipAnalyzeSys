/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/3/10 下午10:24:22                         */
/*==============================================================*/


drop table if exists CHIP_DATA;

drop table if exists CHIP_YIELD;

/*==============================================================*/
/* Table: CHIP_DATA                                             */
*==============================================================*/
create table CHIP_DATA
(
  ID                   varchar(40) not null comment 'ID',
  BATCH_NUMBER         varchar(40) comment '批号',
  PRODUCT_CODE         varchar(40) comment '产品编码',
  VERSION              varchar(20) comment '版本',
  NUMBER_PIECES        numeric(10,0) comment '数量',
  PROCESS_PERIOD       varchar(100) comment '工序段',
  PROCESS              varchar(100) comment '工序',
  PROCESS_CONDITIONS   varchar(40) comment '工艺条件',
  WORK_CENTER          varchar(20) comment '工作中心',
  WORK_UNIT            varchar(20) comment '作业单元',
  OPERATOR             varchar(20) comment '操作人',
  START_TIME           varchar(40) comment '当道开始时间',
  END_TIME             varchar(40) comment '当道结束时间',
  primary key (ID)
);

/*==============================================================*/
/* Table: CHIP_YIELD                                            */
/*==============================================================*/
create table CHIP_YIELD
(
  ID                   varchar(40) not null comment 'ID',
  BATCH_NUMBERBATCH_NUMBER varchar(40) comment '批号',
  NUMBER_PIECES        numeric(10,0) comment '片数',
  PARTICLES            numeric(10,0) comment '颗粒数',
  YIELD                numeric(10,2) comment '良率',
  primary key (ID)
);