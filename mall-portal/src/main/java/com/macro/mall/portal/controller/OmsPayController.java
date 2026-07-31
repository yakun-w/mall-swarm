package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CallBackParam;
import com.macro.mall.portal.domain.OmsPayment;
import com.macro.mall.portal.domain.PayResponse;
import com.macro.mall.portal.service.OmsPayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pay/callback")
@Tag(name = "OmsPayController", description = "第三方支付回调通知入口")
public class OmsPayController {

    @Autowired
    private OmsPayService omsPayService;

    @Operation(summary = "发起支付")
    @RequestMapping(value = "/generatePay", method = RequestMethod.POST)
    @ResponseBody
    public PayResponse generatePay(@RequestBody OmsPayment payment) {
        PayResponse payResponse = omsPayService.createPay(payment);
        return payResponse;
    }
    @Operation(summary = "支付回调")
    @RequestMapping(value = "/callBackPay", method = RequestMethod.POST)
    @ResponseBody
    public OmsPayment callBackPay(@RequestBody CallBackParam callBackParam) {
        OmsPayment omsPayment = omsPayService.payCallback(callBackParam);
        return omsPayment;
    }
}
