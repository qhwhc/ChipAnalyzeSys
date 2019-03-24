/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/3/10 下午10:24:22                         */
/*==============================================================*/


drop table if exists CHIP_DATA;

drop table if exists CHIP_YIELD;

/*==============================================================*/
/* Table: CHIP_DATA                                             */
*==============================================================*/
create table chip_data
(
  id                   int(40) not null auto_increment comment 'ID',
  yield_id             int(40),
  batch_number         varchar(40) comment '批号',
  product_code         varchar(40) comment '产品编码',
  version              varchar(20) comment '版本',
  number_pieces        numeric(10,0) comment '数量',
  process_period       varchar(100) comment '工序段',
  process              varchar(100) comment '工序',
  process_conditions   varchar(40) comment '工艺条件',
  work_center          varchar(20) comment '工作中心',
  work_unit            varchar(20) comment '作业单元',
  operator             varchar(20) comment '操作人',
  start_time           varchar(40) comment '当道开始时间',
  end_time             varchar(40) comment '当道结束时间',
  primary key (ID)
);

/*==============================================================*/
/* Table: CHIP_YIELD                                            */
/*==============================================================*/
create table chip_yield
(
  id                   int(40) not null auto_increment comment 'ID',
  batch_number varchar(40) comment '批号',
  number_pieces        numeric(10,0) comment '片数',
  particles            numeric(10,0) comment '颗粒数',
  yield                numeric(10,2) comment '良率',
  primary key (ID)
);