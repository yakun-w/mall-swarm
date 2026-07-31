package com.macro.mall.portal.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 支付成功事件消息体（纯 POJO，用于 MQ 传输）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSuccessEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderNo;

    private String paymentNo;

    private String thirdTradeNo;
}
