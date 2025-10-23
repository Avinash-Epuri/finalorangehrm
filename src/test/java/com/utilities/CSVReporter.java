package com.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVReporter implements ITestListener {
    private static final String DIRECTORY = "./target";
    private static final String FILE_NAME = DIRECTORY + "/test-report.csv";
    private FileWriter writer;

    @Override
    public void onStart(ITestContext context) {
        try {
            File folder = new File(DIRECTORY);
            if (!folder.exists()) folder.mkdirs();
            writer = new FileWriter(FILE_NAME);
            writer.write("TestName,Status,ExecutionTime(ms),Description\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        writeResult(result, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        writeResult(result, "FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        writeResult(result, "SKIPPED");
    }

    private void writeResult(ITestResult result, String status) {
        try {
            String testName = result.getMethod().getMethodName();
            long duration = result.getEndMillis() - result.getStartMillis();
            String description = result.getMethod().getDescription();
            writer.write(testName + "," + status + "," + duration + "," + (description != null ? description : "") + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            if (writer != null) writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}