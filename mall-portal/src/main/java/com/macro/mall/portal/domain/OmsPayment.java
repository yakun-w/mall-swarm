package com.macro.mall.portal.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付单实体类
 * 对应表：oms_payment
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "支付单实体")
public class OmsPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "支付单号")
    private String paymentNo;

    @Schema(description = "关联订单号")
    private String orderNo;

    @Schema(description = "支付方式：1->支付宝；2->微信")
    private Integer payType;

    @Schema(description = "支付金额")
    private BigDecimal payAmount;

    @Schema(description = "支付状态：0->待支付；1->支付成功；2->支付失败；3->已关闭")
    private Integer payStatus;

    @Schema(description = "第三方交易号（如支付宝 trade_no / 微信 transaction_id）")
    private String thirdTradeNo;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "支付完成时间")
    private Date payTime;
}
