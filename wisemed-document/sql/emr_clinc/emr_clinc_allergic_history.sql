drop table if exists emr_clinc_allergic_history;
create table emr_clinc_allergic_history(
    id varchar(50) not null comment '主键',
    allergicHistory varchar(100) comment '过敏史',
    allergen varchar(100) comment '过敏原',
    allergicSymptom varchar(100) comment '过敏症状',
    allergicSymptomCode varchar(100) comment '过敏症状代码',
    allergenCode varchar(100) comment '过敏原代码',
    allergicMedicineName varchar(100) comment '过敏药物名称',
    allergicStatusCode varchar(100) comment '过敏病情状态代码',
    allergicSeverityCode varchar(100) comment '过敏严重性代码',
    allergicHistoryCode varchar(100) comment '过敏史标识代码',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='过敏史';