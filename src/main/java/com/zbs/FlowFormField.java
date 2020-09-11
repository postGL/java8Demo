package com.zbs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 审批表单字段表
 * </p>
 *
 * @author zhangbs
 * @since 2020-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FlowFormField {

    private static final long serialVersionUID = 1L;

    private String id;

    private String defId;

    private Integer idx;

    private Integer sortBy;

    private String name;

    private String label;

    private String props;

    private Integer important;

    private Integer print;

    private String componentName;

    private String unit;

    private String selectOptions;

    private String format;

    private String tableAction;

    private String components;

    private Integer noteShow;

    private String noteHref;

    private Integer moneyTranslate;

    private String selected;

    private String inTableCanvas;

    private String label2;

    private String props2;

    private Integer autorekonTime;

    private String subtitle;

    private String supportSetting;

    private Integer fileReceiveMode;

}
