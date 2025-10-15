package org.example.Tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RertyTests implements IRetryAnalyzer {
    private int nowCount = 0;
    private static final int maxCount = 10;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (nowCount < maxCount) {
            nowCount++;
            return true;
        }
        nowCount = 0;
        return false;
    }
}

