package com.jwang261.springcloud.alibaba.service.impl;

import com.jwang261.springcloud.alibaba.dao.OrderDao;
import com.jwang261.springcloud.alibaba.entity.Order;
import com.jwang261.springcloud.alibaba.service.AccountService;
import com.jwang261.springcloud.alibaba.service.OrderService;
import com.jwang261.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jwang261
 * @date 2020/8/6 1:34 AM
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "my_test_tx_group", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("prepare to create new order");
        orderDao.create(order);

        log.info("prepare to call storage-Service to change storage");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("finished calling storage-Service to decrease count");

        log.info("prepare to call account-Service to decrease money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("finished calling account-Service to decrease money");

        log.info("prepare to call order-Service to change order status 0 -> 1");
        orderDao.update(order.getUserId(), 0);
        log.info("finished to call order-Service to change order status 0 -> 1");

        log.info("The End");

    }
}
