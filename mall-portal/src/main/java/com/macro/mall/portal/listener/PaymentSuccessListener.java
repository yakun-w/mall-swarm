package com.macro.mall.portal.listener;



import com.macro.mall.portal.event.PaymentSuccessEvent;
import com.macro.mall.portal.service.OmsPortalOrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单模块 - 支付成功消息监听器
 */
@Component
public class PaymentSuccessListener {

    @Autowired
    private OmsPortalOrderService orderService;

    @RabbitListener(queues = "payment.success.queue")
    public void handlePaymentSuccess(PaymentSuccessEvent event) {
        // 调用 order 包自己的 service 修改订单状态、处理后续逻辑
        String i = "as";
        orderService.paySuccess(i,2);
    }
}
