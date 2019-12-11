package com.controller;

import com.entity.*;
import com.google.gson.Gson;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class ProductController {
    @Autowired
    ProductService productService;

    Gson gson = new Gson();


    @RequestMapping("/findAll")
    public List<SKU> findAll() {
        return productService.findAll();
    }

    @RequestMapping(value = "/accessIndex", method = RequestMethod.POST)
    public Pagination accessIndex(@RequestBody Pagination pagination, HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setId(1);
        request.getSession().setAttribute("user", user);
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            Cookie cookie = new Cookie("cart", "");
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return productService.accessIndex(pagination);
    }

    @RequestMapping(value = "/getProductInfo", method = RequestMethod.POST)
    public SKU getProductInfo(@RequestBody Product product) {
        return productService.getProductInfo(product.getpId());
    }

    @RequestMapping(value = "/getFirstCategory", method = RequestMethod.GET)
    public List<Category> getFirstCategory() {
        return productService.getCategory();
    }

    @RequestMapping(value = "/getSecondCategory", method = RequestMethod.POST)
    public List<Category> getSecondCategory(@RequestBody Category category) {
        return productService.getSecondCategory(category.getCategoryId());
    }

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public String[] addCart(@RequestBody Cart cart, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String[] list = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cart")) {
                String value = cookie.getValue();
                value += cart.getSkuId() + "_" + cart.getNum() + "#";
                list = value.split("#");
                cookie.setValue(value);
                cookie.setPath("/");
                response.addCookie(cookie);
                break;
            }
        }
        return list;
    }

    @RequestMapping(value = "/getCartList", method = RequestMethod.GET)
    public List<Cart> getCartList(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String s = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cart")) {
                s = cookie.getValue();
                break;
            }
        }
        String[] split = s.split("#");
        List<String> list = new ArrayList<>();
        if (split.length > 0) {
            for (String str : split) {
                list.add(str);
            }
        }
        List<Cart> carts = new ArrayList<>();
        for (String str : list) {
            Cart cart = new Cart();
            String[] s1 = str.split("_");
            cart.setNum(Integer.parseInt(s1[1]));
            cart.setSkuId(Integer.parseInt(s1[0]));
            cart.setSku(productService.getSKUById(Integer.parseInt(s1[0])));
            carts.add(cart);
        }
        return carts;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public void addProduct(@RequestBody SKU sku) {
        productService.addProduct(sku);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        String s = request.getServletContext().getRealPath("") + "upload" + File.separator + fileName;
        File destFile = new File(s);
        destFile.getParentFile().mkdirs();
        file.transferTo(destFile);
        return fileName;
    }
}