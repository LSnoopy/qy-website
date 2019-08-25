package com.hani.service.impl;

import com.hani.constant.PromptConstant;
import com.hani.dao.AdminMapper;
import com.hani.domain.Admin;
import com.hani.domain.AdminCriteria;
import com.hani.service.AdminService;
import com.hani.vo.JsonResponse;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/12 下午5:30.
 * </pre>
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void addAdmin(Admin admin) {
        admin.setCreateTime(new Date());
        adminMapper.insert(admin);
    }

    @Override
    public JsonResponse login(String userName, String pwd) {
        AdminCriteria param = new AdminCriteria();
        param.setLimit(1);
        param.createCriteria().andUserNameEqualTo(userName);
        List<Admin> admins = adminMapper.selectByExample(param);
        if (CollectionUtils.isNotEmpty(admins)) {
            Admin admin = admins.get(0);
            if (!StringUtils.equals(admin.getPwd(), pwd)) {
                return new JsonResponse(JsonResponse.FAIL, PromptConstant.ERROR_PWD);
            }
            return new JsonResponse(JsonResponse.SUCCESS, "success");
        }
        return new JsonResponse(JsonResponse.FAIL, PromptConstant.ERROR_USER);
    }

    @Override
    public JsonResponse updatePwd(String userName, String oldPwd, String newPwd) {
        AdminCriteria param = new AdminCriteria();
        param.setLimit(1);
        param.createCriteria().andUserNameEqualTo(userName);
        List<Admin> admins = adminMapper.selectByExample(param);
        if (CollectionUtils.isNotEmpty(admins)) {
            Admin admin = admins.get(0);
            if (!StringUtils.equals(admin.getPwd(), oldPwd)) {
                return new JsonResponse(JsonResponse.FAIL, PromptConstant.ERROR_OLD_PWD);
            }
            admin.setModifyTime(new Date());
            admin.setPwd(newPwd);
            adminMapper.updateByPrimaryKeySelective(admin);
            return new JsonResponse(JsonResponse.SUCCESS, "success");
        }
        return new JsonResponse(JsonResponse.FAIL, PromptConstant.ERROR_USER);
    }
}
