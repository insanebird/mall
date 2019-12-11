package com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String stampToDate(Long time) {
        return simpleDateFormat.format(new Date(time));
    }
}
