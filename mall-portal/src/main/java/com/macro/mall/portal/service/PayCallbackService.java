package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.OmsPayment;

public interface PayCallbackService {

    void createPay(OmsPayment payment);

    void payCallback(OmsPayment payment);
}
