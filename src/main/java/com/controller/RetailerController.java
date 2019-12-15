package com.controller;

import com.common.DateFormat;
import com.entity.Retailer;
import com.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
public class RetailerController {
    @Autowired
    RetailerService retailerService;

    @RequestMapping(value = "/getRetailerList", method = RequestMethod.GET)
    public List<Retailer> getRetailerList() {
        return retailerService.getRetailerList();
    }

    @RequestMapping(value = "/addRetailer", method = RequestMethod.POST)
    public Retailer addRetailer(@RequestBody Retailer retailer, HttpServletRequest request) {
        retailer.setFoundTime(new Date());
        retailer.setDisplayTime(DateFormat.stampToDate(retailer.getFoundTime().getTime()));
        retailerService.addRetailer(retailer);
        return retailer;
    }

    @RequestMapping(value = "/checkRetailer", method = RequestMethod.POST)
    public String checkRetailer(@RequestBody Retailer retailer) {
        if (retailerService.checkRetailer(retailer.getName())) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping(value = "/getRetailerByFounder", method = RequestMethod.POST)
    public Retailer getRetailerByFounder(@RequestBody Retailer retailer) {
        return retailerService.getRetailerByFounder(retailer.getFounder());
    }

    @RequestMapping(value = "/changeRetailerInformation", method = RequestMethod.POST)
    public Retailer changeRetailerInformation(@RequestBody Retailer retailer) {
        return retailerService.changeRetailerInformation(retailer);
    }
}