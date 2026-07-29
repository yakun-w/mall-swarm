package com.macro.mall.portal.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class PaymentNoUtil {

    /**
     * 生成支付单号
     * 格式：PAY + 年月日时分秒 + 6位随机数
     * 例如：PAY20260728204512984210
     */
    public static String generatePaymentNo() {
        // 1. 时间戳格式化 (14位: yyyyMMddHHmmss)
        String timeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        // 2. 生成 6 位随机数
        int randomNum = ThreadLocalRandom.current().nextInt(100000, 999999);

        // 3. 拼接业务前缀 PAY
        return "PAY" + timeStr + randomNum;
    }
}
