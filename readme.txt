2014-04-22 与胖子商量今后所做项目的名称为 Pyramid

项目名称：Pyramid

	千里之行，驶于足下。虽然走得慢，但只要坚持下去，会实现自己的愿望。

项目介绍：
    1、定位于 OpenSource Project
    2、内嵌网络爬虫
    3、开发自己的分布式数据库，对数据的存储（未整合）
    4、开发基于LUCENE的分词，并实现中文与拼音之间的转换（未整合）
    5、开发界面，实现 Restful 访问，进行数据展示，以及对爬虫指令的设置。（未整合）
    6、整合HADOOP及相关组件（视以后应用到的组件而定），对爬虫数据进行处理。（未整合）
    7、集成流处理（如 STORM, KAFKA STREAMING, SPARK STREAMING 供用户选择）。（未实现）
    8、WEB 应用的 HA 实现（暂未实现）

编译顺序：
    mvn clean install -Dmaven.test.skip=true (-X)

    1、DB - 数据库访问层
    2、Entity - 实体映射
    3、Utils - 工作类
    4、DAO - 数据库操作层
    5、Service - 业务逻辑层
    6、RPC - Restful API 层
    7、Web - Web 应用层

工作日志：

2018-05-16
	（1）网络爬虫 - 功能基本完成，需要优化性能，可考虑由线程转为进程的处理方式。
	（2）优化整体 POM 文件中的依赖。（已完成）
	（3）处理 SPRING 与 JAX-RS 集成时，出现的BUG。（已完成）