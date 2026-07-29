package com.macro.mall.portal.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 统一支付响应结果（返回给前端拉起支付所需数据）
 */
@Data
@Schema(description = "统一支付响应对象")
public class PayResponse {

    @Schema(description = "H5/网页跳转链接（网页端支付或 Mock 模拟支付跳转页）")
    private String payUrl;
}
