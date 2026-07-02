package com.electra.automation.constants;

public final class FrameworkConstants {
    private FrameworkConstants() {}

    public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/config/config.properties";
    public static final String TESTDATA_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/config/testData.properties";
    public static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "/Screenshots/";
    public static final String EXTENT_REPORT_PATH = System.getProperty("user.dir") + "/ExtentReports/";
    public static final String LOGS_PATH = System.getProperty("user.dir") + "/Logs/";
    public static final String EXCEL_PATH = System.getProperty("user.dir") + "/src/main/resources/testdata/TestData.xlsx";
}
