package com.imooc.two.dubbo.server.controller;

import com.imooc.two.dubbo.api.enums.ResponseCode;
import com.imooc.two.dubbo.api.response.BaseResponse;
import com.imooc.two.dubbo.server.request.OrderCommitRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

/**
 * Created by rabbit on 2019/7/3.
 */
@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private static final String prefix = "order";

    @RequestMapping(value = prefix + "/commit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
    public BaseResponse orderCommit(@RequestBody OrderCommitRequest orderCommitRequest){
        try {
            logger.info("接收到用户传来的请求参数", orderCommitRequest);
        }catch(Exception ex){
            return BaseResponse.createByErrorCodeAndErrorMessage(ResponseCode.ERROR.getCode(), ex.getMessage());
        }
        return BaseResponse.createBySuccess();
    }
}
