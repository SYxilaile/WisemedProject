drop table if exists emr_clinc_physical_examination;
create table emr_clinc_physical_examination(
    id varchar(50) not null comment '主键',
    observeCategory varchar(50) default '体格检查' comment '',
    observeCategoryCode varchar(50)  comment '观察-类别代码',
    observeItemName varchar(50)  comment '观察项目名称',
    observeItemCode varchar(50)  comment '观察-项目代码',
    observeResultDesc varchar(200)  comment '观察-结果描述',
    observationValue varchar(50)  comment '观察-结果(数值)',
    observeMeasureUnit varchar(50)  comment '观察-计量单位',
    observeResultCode varchar(50)  comment '观察-结果代码',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='体格检查信息表';