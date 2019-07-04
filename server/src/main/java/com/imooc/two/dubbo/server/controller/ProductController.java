package com.imooc.two.dubbo.server.controller;

import com.imooc.two.dubbo.api.response.BaseResponse;
import com.imooc.two.dubbo.module.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabbit on 2019/6/3.
 */
@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private static final String prefix = "product";

    @Autowired
    private com.imooc.one.dubbo.api.service.IDubboProductService iDubboProductService;

    @RequestMapping(value = prefix + "/list", method = RequestMethod.GET)
    public BaseResponse<List<Product>> productList(){

        List<Product> productList = new ArrayList<Product>();
        try{
            productList = (List<Product>)iDubboProductService.listProducts().getData();
        }catch(Exception ex){
            ex.printStackTrace();
            return BaseResponse.createByError();
        }
        return BaseResponse.createBySuccess(productList);
    }

    @RequestMapping(value = prefix + "/list" + "/page", method = RequestMethod.GET)
    public BaseResponse productListByPage(@RequestParam("pageNum") Integer pageNum,
                                                             @RequestParam("pageSize") Integer pageSize){
        if(pageNum == null || pageNum == 0 || pageSize == null || pageSize == 0){
            logger.info("params pageNum or pageSize are null!");
            pageNum = 1;
            pageSize = 2;
        }
        return BaseResponse.createBySuccess(iDubboProductService.listProductsByPage(pageNum, pageSize).getData());
    }

    @RequestMapping(value = prefix + "/list" + "/keyword", method = RequestMethod.GET)
    public BaseResponse productListByKeyWord(@RequestParam("pageNum") Integer pageNum,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam("keyWord") String keyWord){
        if(pageNum == null || pageNum == 0 || pageSize == null || pageSize == 0){
            logger.info("params pageNum or pageSize are null!");
            pageNum = 1;
            pageSize = 2;
        }
        return BaseResponse.createBySuccess(iDubboProductService.listProductsByKeyword(pageNum, pageSize, keyWord).getData());
    }
}
