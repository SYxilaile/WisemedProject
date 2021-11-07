drop table if exists emr_prescription_insurance;
create table emr_prescription_insurance(
    id varchar(50) not null comment '主键',
    medicareCategory varchar(50) comment '医疗保险-类别',
    medicareCategoryCode varchar(50) comment '医疗保险-类别代码',
    medicareName varchar(100) comment '医疗待遇名称',
    medicareCode varchar(100) comment '医疗待遇代码',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='门(急)诊处方数据集医保信息';