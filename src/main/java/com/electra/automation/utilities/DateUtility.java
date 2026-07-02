package com.electra.automation.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtility {
    public static String getCurrentDateTime(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }
}
