#  question 表
DROP TABLE IF EXISTS question;
create table question
(
  questionID varchar(64) NOT NULL COMMENT 'questionID',
  createTime datetime DEFAULT NULL COMMENT '创建时间',
  topic text COMMENT '题目',
  answer text COMMENT '答案选项',
  rightAnswer text COMMENT '正确答案',
  questionExplain text COMMENT '解释',
  deleteFlag tinyint(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (questionID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='编码和引擎';

#  插入测试数据
INSERT INTO question VALUES ('1', '2015-08-31 15:53:19', '下列医疗措施，使人体产生抗体，获得免疫的是_____', '[\"服用阿司匹林\",\"注射胰岛素\",\"注射疫苗 \",\"注射抗生素\"]', '[0]', '免疫是人体一种生理功能，通过免疫识别自己和非己成分，从而破坏和排斥进入人体的抗原物质，维持人体内部环境的平衡和稳定。引起人体产生抗体的物质称为抗原，抗原一般情况下指的是病原体，注射疫苗能引起人体产生抗体，获得免疫。服用阿司匹林和注射抗生素，不能使人体产生抗体。胰岛素是一种激素，调节糖的代谢，都不属于抗原，因而不能引起人体产生免疫反应。', '0');