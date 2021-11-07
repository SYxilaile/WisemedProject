drop table if exists emr_clinc_history_illness;
create table emr_clinc_history_illness(
    id varchar(50) not null comment '主键',
    historyObserveName varchar(100) comment '既往观察-项目名称',
    historyObserveCategoryCode varchar(100) comment '既往观察-项目分类代码',
    historyObserveCodeName varchar(100) comment '既往观察-项目代码名称',
    historyObserveCode varchar(100) comment '既往观察-项目代码',
    historyObserveMethodCode varchar(100) comment '既往观察-方法代码',
    historyObserveEffect varchar(100) comment '既往观察-结果',
    historyObserveProjeName varchar(100) comment '既往史观察项目类目名称',
    historyObserveResult varchar(100) comment '既往史观察结果',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='既往史';