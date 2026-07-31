package com.macro.mall.portal.service.impl;


import com.macro.mall.mapper.OmsOrderMapper;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.portal.dao.PortalPayDao;
import com.macro.mall.portal.domain.CallBackParam;
import com.macro.mall.portal.domain.OmsPayment;
import com.macro.mall.portal.domain.PayResponse;
import com.macro.mall.portal.service.OmsPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmsPayServiceImpl implements OmsPayService {

    @Autowired
    private OmsOrderMapper orderMapper;

    @Autowired
    private PortalPayDao payDao;

    @Override
    public PayResponse createPay(OmsPayment payment) {
        PayResponse response = new PayResponse();
        response.setPayUrl("https://mock-pay/" + payment.getPaymentNo());
        return response;
    }

    @Override
    public OmsPayment payCallback(CallBackParam callBackParam) {
        //检查参数
        OmsPayment payment =
                payDao.selectByPaymentNo(
                        callBackParam.getPaymentNo()
                );
        if (payment == null) {
            throw new RuntimeException("支付单不存在");
        }

// 2. 校验支付金额是否一致（注意：BigDecimal 比较必须用 compareTo）
        if (payment.getPayAmount().compareTo(callBackParam.getPayAmount()) != 0) {
            throw new RuntimeException("支付金额与订单金额不一致");
        }

// 3. 校验状态是不是待支付（假设 0 代表待支付）
        if (payment.getPayStatus() != 0) {
            return payment;
        }

// 4. 校验第三方流水是否重复（如果数据库里已经有了 thirdTradeNo，说明该流水被重复通知）
        if (payment.getThirdTradeNo() != null && payment.getThirdTradeNo().equals(callBackParam.getThirdTradeNo())) {
            throw new RuntimeException("第三方交易流水号重复，疑似重复回调");
        }
        //支付单参数
        payment.setPaymentNo(callBackParam.getPaymentNo());
        payment.setPayStatus(callBackParam.getPayResult());
        payment.setPayTime(callBackParam.getPayTime());
        payment.setThirdTradeNo(callBackParam.getThirdTradeNo());
        payDao.updatePayment(payment);
        return payment;
    }
}
