package com.csp.project.service;

/**
 * @author 陈少平
 * @date 2021-02-08 23:32
 */
public interface TestService {

    void updateData(Integer id, String name);

    void startTransactionWithSelect();
}
