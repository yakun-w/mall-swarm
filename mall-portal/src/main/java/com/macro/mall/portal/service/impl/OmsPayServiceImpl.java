package com.macro.mall.portal.service.impl;


import com.macro.mall.mapper.OmsOrderMapper;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.portal.domain.OmsPayment;
import com.macro.mall.portal.domain.PayResponse;
import com.macro.mall.portal.service.OmsPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmsPayServiceImpl implements OmsPayService {

    @Autowired
    private OmsOrderMapper orderMapper;

    @Override
    public PayResponse createPay(OmsPayment payment) {
        PayResponse response = new PayResponse();
        response.setPayUrl("https://mock-pay/" + payment.getPaymentNo());
        return response;
    }

    @Override
    public void payCallback(OmsPayment payment) {

    }
}
