package Assignments1;

import org.testng.Assert;
import org.testng.annotations.*;

public class Testing4
{
    @Test
    public void parlleltesting1()
    {
        System.out.println("executing 1st parallel method");
        Assert.assertEquals("1","1");
    }
    @BeforeMethod
    public void parlleltesting2()
    {
        System.out.println("excuting 2nd parallel mathod");
    }
    @Test
    public void parlleltesting3()
    {
        System.out.println("excuting 3rd parallel mathod");
    }
}
