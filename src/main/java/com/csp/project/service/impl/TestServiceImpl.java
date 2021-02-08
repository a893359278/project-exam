package com.csp.project.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import com.csp.project.mapper.TestMapper;
import com.csp.project.model.Test;
import com.csp.project.service.TestService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 陈少平
 * @date 2021-02-08 23:33
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    TestMapper testMapper;

    @Override
    public void updateData(Integer id, String name) {
        Test test = new Test();
        test.setId(id);
        test.setName(name);
        testMapper.updateByPrimaryKey(test);
    }

    @Override
    @Transactional
    public void startTransactionWithSelect() {
        ThreadUtil.sleep(5000);
        List<Test> tests = testMapper.selectAll();
        tests.forEach(System.out::println);
    }
}
