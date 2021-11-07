drop table if exists emr_prescription_contacts;
create table emr_prescription_contacts(
    id varchar(50) not null comment '主键',
    servObjPapersCategory varchar(100) comment '标识号-类别代码',
    servObjPapersCode varchar(100) comment '标识号-号码*',
    servObjPapersEffectDate varchar(100) comment '标识号-生效日期',
    servObjPapersInvalidDate varchar(100) comment '标识号-失效日期',
    servObjPapersOrgName varchar(100) comment '标识号-提供标识的机构名称',
    nameCategory varchar(100) comment '姓名-标识对象',
    nameCategoryCode varchar(100) comment '姓名-标识对象代码',
    contactsName varchar(100) comment '代办人姓名',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='门(急)诊处方数据集联系人';