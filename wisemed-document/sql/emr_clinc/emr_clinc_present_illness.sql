drop table if exists emr_clinc_present_illness;
create table emr_clinc_present_illness(
  id varchar(50) not null comment '主键',
  paroxysmTime date comment '起病时间',
  paroxysmSolarTermsCode varchar(100) comment '起病节气归属代码',
  paroxysmDesc varchar(100) comment '起病情况描述',
  paroxysmReason varchar(100) comment '症状开始原因/诱因',
  symptomTrait varchar(100) comment '症状特点',
  symptomComply varchar(100) comment '伴随症状',
  historyTreat varchar(100) comment '本疾病既往诊疗经过',
  paroxysmLaterDesc varchar(100) comment '起病后一般情况',
  baseIllnessTreat varchar(100) comment '基础疾病诊疗情况',
  primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='现病史';