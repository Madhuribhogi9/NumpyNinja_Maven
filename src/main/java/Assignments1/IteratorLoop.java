package Assignments1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorLoop
{
    public static void main(String[] args)
    {
        List<String> names = new ArrayList<String>();

        names.add("sadeep");
        names.add("sade454ep");
        names.add("sade54ep");
        names.add("sade545ep");

        for (Iterator<String> iterator = names.iterator(); iterator.hasNext(); )
        {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}
