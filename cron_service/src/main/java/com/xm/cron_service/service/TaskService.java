package com.xm.cron_service.service;

import com.mogujie.openapi.exceptions.ApiException;
import com.xm.comment_serialize.module.user.entity.SuOrderEntity;
import com.xm.comment_utils.mybatis.PageBean;

import java.util.Date;

public interface TaskService {

    /**
     * 按最后更新时间查询订单
     * @param startUpdateTime
     * @param endUpdateTime
     * @return
     */
    public PageBean<SuOrderEntity> getOrderByIncrement(Date startUpdateTime, Date endUpdateTime, Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 根据单号查订单
     * @param orderNum
     * @return
     */
    public SuOrderEntity getOrderByNum(String orderNum) throws Exception;

    /**
     * 获取系统时间
     * @return
     */
    public Date getTime() throws Exception;
}
