package com.service;

import com.dao.RotationChartDao;
import com.entity.RotationChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RotationChartService {
    @Autowired
    RotationChartDao rotationChartDao;

    public RotationChart addRotationChart(RotationChart rotationChart) {
        rotationChartDao.addRotationChart(rotationChart);
        return rotationChart;
    }

    public RotationChart getHorizontalChart() {
        return rotationChartDao.getHorizontalChart();
    }

    public RotationChart getVerticalChart() {
        return rotationChartDao.getVerticalChart();
    }
}
