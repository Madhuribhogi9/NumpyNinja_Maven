package Assignment3;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportsPractice
{
    public static void main(String[] args)
    {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter sparkreport = new ExtentSparkReporter("Extentreport.html");
        extent.attachReporter(sparkreport);
        ExtentTest test = extent.createTest("first test case");
        test.fail("this is passed");
        extent.createTest("madhu").log(Status.INFO,"info1");
        extent.createTest("madhu1").log(Status.FAIL,"info2");
        extent.createTest("madhu3").log(Status.PASS,"info4");
        extent.createTest("madhu4").log(Status.INFO,"info5");
        extent.createTest("madhu5").log(Status.INFO,"info6");
        extent.flush();

        //}
    /*ExtentReports extent;
    ExtentTest test;
    @BeforeMethod
    public void beforeclass()
    {
        extent = new ExtentReports();
        ExtentSparkReporter sparkreport = new ExtentSparkReporter("Extentreport.html");
        extent.attachReporter(sparkreport);
    }
    @Test
    public  void test1()
    {
        test = extent.createTest("first test case").log(Status.INFO,"1");

    }
    @Test
    public void test2()
    {
        test = extent.createTest("second test case").log(Status.PASS,"2");
    }
    @AfterMethod
    public void aftermethod()
    {
        extent.flush();
    }*/

    }
}
