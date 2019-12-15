package com.controller;

import com.entity.RotationChart;
import com.service.RotationChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class RotationChartController {
    @Autowired
    RotationChartService rotationChartService;

    @RequestMapping(value = "/addRotationChart", method = RequestMethod.POST)
    public RotationChart addRotationChart(@RequestBody RotationChart rotationChart) {
        return rotationChartService.addRotationChart(rotationChart);
    }

    @RequestMapping(value = "/getHorizontalChart", method = RequestMethod.GET)
    public RotationChart getHorizontalChart() {
        return rotationChartService.getHorizontalChart();
    }

    @RequestMapping(value = "/getVerticalChart", method = RequestMethod.GET)
    public RotationChart getVerticalChart() {
        return rotationChartService.getVerticalChart();
    }
}
