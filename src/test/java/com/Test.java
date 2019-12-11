package com;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long l = new Long("1575936000000");
        String format = simpleDateFormat.format(new Date(l));
        System.out.println(format);
    }
}
