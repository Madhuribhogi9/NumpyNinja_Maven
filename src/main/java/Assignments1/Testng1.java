package Assignments1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testng1
{
    @DataProvider
    public Object[][] testing1()
    {
        Object obj[][] ={{"yes","no"},{"user","pass"}};
        return obj;
    }
    @Test(dataProvider = "testing1")
    public void testing2(String a,String b)
    {
        System.out.println(a+"and"+b);
    }


}
