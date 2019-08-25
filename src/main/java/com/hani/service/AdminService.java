package com.hani.service;

import com.hani.domain.Admin;
import com.hani.vo.JsonResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/12 下午5:29.
 * </pre>
 */
public interface AdminService {

//    @Transactional(rollbackFor = DataAccessException.class)
    void addAdmin(Admin admin);

//    @Transactional(readOnly = true)
    JsonResponse login(String userName, String pwd);

//    @Transactional(rollbackFor = DataAccessException.class)
    JsonResponse updatePwd(String userName, String oldPwd, String newPwd);
}
