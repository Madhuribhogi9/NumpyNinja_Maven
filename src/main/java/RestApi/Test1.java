package RestApi;

import static io.restassured.RestAssured.*;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Test1
{

    @Test
    public void testcase1()
    {
        Response response = get("https://reqres.in/api/users?page=2");
       // System.out.println(response.getStatusCode());
        //System.out.println(response.headers());
        //System.out.println(response.contentType());
        System.out.println(response.body().asString());
    }
    @Test
    public void testcase2()
    {
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2").then().statusCode(200).body("data[0].first_name",equalTo("Michael")).log().all();
    }
    @Test
    public void testcase3()
    {
        baseURI = "https://reqres.in/api";
       // given().get("/users?page=2").then().body("data[2].first_name",equalTo("Tobias"));
        given().get("/users?page=2").then().body("data.first_name",hasItems("Tobias","Byron"));
    }
    @Test
    public void testcase4()
    {
        baseURI = "https://reqres.in/api";
        PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","leader");
        System.out.println(request.toJSONString());
        given().body(request.toJSONString()).post("api/users").then().statusCode(201).log().all();
    }

}
