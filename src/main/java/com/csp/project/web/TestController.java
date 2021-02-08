package com.csp.project.web;

import com.csp.project.service.TestService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈少平
 * @date 2021-02-08 23:32
 */
@RestController
public class TestController {

    @Resource
    TestService testService;

    // 测试一：jdbc 是否在开启事务的时候，就创建了 read-view，还是在第一次读数据的时候才创建
    // todo 结论：JDBC 也是以 begin/start transaction 方式启动事务的，因此，read view 的创建是在第一个快照读语句发生时

    // 该方法先执行
    @GetMapping("/testTransactionReadView1")
    public Object testTransactionReadView1() {
        testService.startTransactionWithSelect();
        return 1;
    }

    @GetMapping("/testTransactionReadView2")
    public Object testTransactionReadView2(Integer id, String name) {
        testService.updateData(id, name);
        return 2;
    }





}
