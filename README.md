### 测试一
jdbc 是否在开启事务的时候，就创建了 read-view，还是在第一次读数据的时候才创建

结论：JDBC 也是以 begin/start transaction 方式启动事务的，因此，read view 的创建是在第一个快照读语句发生时
