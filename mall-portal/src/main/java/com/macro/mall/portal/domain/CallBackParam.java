package com.macro.mall.portal.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 支付回调通知入参（第三方支付平台或模拟测试回调时传参）
 */
@Data
@Schema(description = "支付回调通知参数")
public class CallBackParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "支付结果：1->成功；2->失败")
    private Integer payResult;

    @Schema(description = "第三方交易流水号（支付宝/微信产生的流水号，如：202607302200143210）")
    private String thirdTradeNo;

    @Schema(description = "支付金额")
    private BigDecimal payAmount;

    @Schema(description = "系统内部支付单号（如：PAY202607301200001）")
    private String paymentNo;

    @Schema(description = "支付成功时间")
    private Date payTime;


}
