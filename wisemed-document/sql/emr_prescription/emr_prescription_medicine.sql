drop table if exists emr_prescription_medicine;
create table emr_prescription_medicine(
    id varchar(50) not null comment '主键',
    medicineUsage varchar(100) comment '药物用法',
    medicineFrequency varchar(100) comment '药物使用-频率',
    medicineUnit varchar(100) comment '药物使用-剂量单位',
    medicineDosageOneTime varchar(100) comment '药物使用-次剂量',
    medicineTotalDosage varchar(100) comment '药物使用-总剂量',
    medicinePathway varchar(100) comment '药物使用-途径代码',
    medicineName varchar(100) comment '药物名称',
    medicineCategoryCode varchar(100) comment '药物剂型代码',
    medicineCategory varchar(100) comment '药物类型',
    medicineNameCode varchar(100) comment '药物名称代码',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='门(急)诊处方数据集用药信息表'