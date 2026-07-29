package com.macro.mall.portal.service.impl;


import com.macro.mall.mapper.OmsOrderMapper;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.portal.domain.OmsPayment;
import com.macro.mall.portal.service.PayCallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayCallbackServiceImpl implements PayCallbackService {

    @Autowired
    private OmsOrderMapper orderMapper;

    @Override
    public void createPay(OmsPayment payment) {
        //payment没有

        //        支付宝回调-->验证签名

//        验证签名-->检查状态
        OmsOrder omsOrder = orderMapper.selectByPrimaryKey(1L);
        if (omsOrder.getStatus() != 0) {
            return;
        }
        notify(已支付);
    }

    @Override
    public void payCallback(OmsPayment payment) {

    }
}
