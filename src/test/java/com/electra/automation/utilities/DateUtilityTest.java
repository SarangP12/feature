package com.electra.automation.utilities;

import java.time.YearMonth;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DateUtilityTest {

    @Test
    public void parseMonthYearHeader_handlesNewLineSeparatedMonthAndYear() {
        YearMonth actual = DateUtility.parseMonthYearHeader("October\n2026");
        Assert.assertEquals(actual, YearMonth.of(2026, 10));
    }

    @Test
    public void parseMonthYearHeader_handlesSingleLineMonthAndYear() {
        YearMonth actual = DateUtility.parseMonthYearHeader("October 2026");
        Assert.assertEquals(actual, YearMonth.of(2026, 10));
    }
}
