package com.xm.comment_serialize.module.mall.form;

import com.xm.comment_serialize.form.BaseForm;
import lombok.Data;

/**
 * 商品列表表单
 */
@Data
public class GoodsListForm extends BaseForm {
    private Integer pageNum;
    private Integer pageSize;
    private String listType;
}
