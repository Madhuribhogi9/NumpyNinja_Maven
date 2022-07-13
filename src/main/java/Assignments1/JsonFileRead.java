package Assignments1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonFileRead
{
    public static void main(String[] args) throws IOException, ParseException
    {
        JSONArray ja = (JSONArray) new JSONParser().parse(new FileReader("C:\\Users\\admin\\Desktop\\jsonFile.json"));





        for (int i = 0; i <2 ; i++)
        {
            JSONObject jo = (JSONObject) ja.get(i);

            String firstName = (String) jo.get("firstName");
            String lastName = (String) jo.get("lastName");
            String role = (String) jo.get("role");

            System.out.println(firstName);
            System.out.println(lastName);
            System.out.println(role);
        }


        }
    }
