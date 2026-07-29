package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.OmsPayment;
import com.macro.mall.portal.domain.PayResponse;

public interface OmsPayService {

    PayResponse createPay(OmsPayment payment);

    void payCallback(OmsPayment payment);
}
