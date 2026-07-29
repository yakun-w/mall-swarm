package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.OmsPayment;
import com.macro.mall.portal.domain.OrderParam;
import com.macro.mall.portal.service.PayCallbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pay/callback")
@Tag(name = "PayCallbackController", description = "第三方支付回调通知入口")
public class PayCallbackController {

    @Autowired
    private PayCallbackService payCallbackService;
    //发起支付
    @Operation(summary = "发起支付")
    @RequestMapping(value = "/generatePay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generatePay(@RequestBody OmsPayment payment) {
        Map<String, Object> result = payCallbackService.createPay(payment);
        return CommonResult.success(result, "下单成功");
    }
}
