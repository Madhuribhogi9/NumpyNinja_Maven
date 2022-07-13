package Assignments1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testing2
{
    @Parameters({"madhu", "2"})
    public void suitemethod()
    {
        System.out.println("executing suite method");
    }
    @Test(groups = {"sanity"})
    public void testmethod1()
    {
        System.out.println("hello selenium");
    }
    @Test(groups = {"regression"})
    public void testmethod2()
    {
        System.out.println("hello java");
    }
}
