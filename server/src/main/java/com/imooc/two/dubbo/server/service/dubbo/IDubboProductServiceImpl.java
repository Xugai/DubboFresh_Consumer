package com.imooc.two.dubbo.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.imooc.two.dubbo.api.response.BaseResponse;
import com.imooc.two.dubbo.api.service.IDubboProductService;
import com.imooc.two.dubbo.module.entity.Product;
import com.imooc.two.dubbo.module.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by rabbit on 2019/6/1.
 */
@Service(protocol = {"dubbo", "rest"}, validation = "true", version = "1.0", timeout = 3000)
@Path("baseDubbo")
public class IDubboProductServiceImpl implements IDubboProductService {

    private static final Logger logger = LoggerFactory.getLogger(IDubboProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    /**
     * 商品列表信息服务——返回商品列表信息
     * @return
     */
    @Path("product/list")
    public BaseResponse listProducts() {
        List<Product> productList = productMapper.selectAll();
        logger.info("查询到的商品列表信息： {}", productList);
        return BaseResponse.createBySuccess(productList);
    }
}
