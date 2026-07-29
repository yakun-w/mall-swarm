package com.macro.mall.portal.dao;

import com.macro.mall.portal.domain.OmsPayment;
import org.springframework.data.repository.query.Param;

/**
 * 模拟支付持久层 DAO
 */
public interface PortalPayDao {

    /**
     * 插入支付单记录
     *
     * @param payment 支付单实体对象
     * @return 影响行数
     */
    int insertPayment(OmsPayment payment);

    /**
     * 根据支付单号（paymentNo）查询支付单
     *
     * @param paymentNo 本地支付单号
     * @return 支付单实体
     */
    OmsPayment selectByPaymentNo(@Param("paymentNo") String paymentNo);
}
