package com.xm.api_user.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.xm.api_user.service.UserService;
import com.xm.comment.annotation.LoginUser;
import com.xm.comment.response.Msg;
import com.xm.comment.response.R;
import com.xm.comment_serialize.module.user.dto.ProxyProfitDto;
import com.xm.comment_serialize.module.user.form.GetProxyProfitForm;
import com.xm.comment_utils.mybatis.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户下级代理
     * @param userId
     * @return
     */
    @GetMapping("/profit")
    public Msg<PageBean<ProxyProfitDto>> get(@LoginUser Integer userId, @Valid GetProxyProfitForm getProxyProfitForm, BindingResult bindingResult){
        PageBean<ProxyProfitDto> pageBean = userService.getProxyProfit(
                userId,
                getProxyProfitForm.getState(),
                getProxyProfitForm.getOrderColumn(),
                getProxyProfitForm.getOrderBy(),
                getProxyProfitForm.getPageNum(),
                getProxyProfitForm.getPageSize());
        pageBean.getList().stream().forEach(o -> {
//            o.setProxyName(StrUtil.hide(o.getProxyName(),3,4));
            o.setCreateTime(DateUtil.format(DateUtil.parse(o.getCreateTime()),"MM-dd HH:mm"));
        });

        return R.sucess(pageBean);
    }


}
