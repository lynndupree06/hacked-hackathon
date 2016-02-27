package com.hacked.utility;

import java.util.HashMap;
import java.util.Map;

public class Config {
    public static Map<String, Integer> months = new HashMap<>();

    public Config() {
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);
    }

    public int getMonth(String month) {
        return months.get(month);
    }
}
