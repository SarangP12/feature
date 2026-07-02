package com.electra.automation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.electra.automation.constants.FrameworkConstants;

import java.io.File;
import java.io.IOException;

public class ExtentManager {
    private static ExtentReports extent;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(new File(FrameworkConstants.EXTENT_REPORT_PATH + "extent-report.html"));
            try {
                spark.loadXMLConfig("src/main/resources/extent-config.xml");
            } catch (IOException e) {
                throw new RuntimeException("Unable to load Extent report configuration", e);
            }
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
