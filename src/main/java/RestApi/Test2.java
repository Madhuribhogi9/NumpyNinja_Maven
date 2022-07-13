package RestApi;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Test2
{
    @Test
    public void testcase1()
    {

        given().get("https://reqres.in/api/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"));

    }
}
