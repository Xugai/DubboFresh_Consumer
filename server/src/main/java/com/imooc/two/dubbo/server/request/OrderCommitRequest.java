package com.imooc.two.dubbo.server.request;

import lombok.Data;
import lombok.ToString;

/**
 * Created by rabbit on 2019/7/4.
 */
@Data
@ToString
public class OrderCommitRequest {

    private Integer productId;

    private Integer quantity;

    private Integer userId;
}
