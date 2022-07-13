package Assignments1;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ScreenshotInjava
{
    public static void main(String[] args) throws Exception
    {
        XWPFDocument docx = new XWPFDocument();
        XWPFRun run = docx.createParagraph().createRun();
        FileOutputStream out = new FileOutputStream("C:\\Users\\admin\\Desktop\\Doc1.docx");
        Map<Long,File> map = new HashMap<Long, File>();

        for (int counter = 1; counter <= 5; counter++)
        {
            captureScreenShot(docx, run, out,map);
            List<Long> list = new ArrayList<Long>(map.keySet());
            Collections.sort(list);
            TimeUnit.SECONDS.sleep(1);
        }

        docx.write(out);
        out.flush();
        out.close();

    }

    public static void captureScreenShot(XWPFDocument docx, XWPFRun run, FileOutputStream out, Map<Long, File> map) throws Exception
    {
        String screenshot_name = System.currentTimeMillis() + ".png";
    long time = System.currentTimeMillis();
    BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    File file = new File("C:\\Users\\admin\\Desktop\\pasting_screenshots" + screenshot_name);
    ImageIO.write(image, "png", file);
    InputStream pic = new FileInputStream("C:\\Users\\admin\\Desktop\\pasting_screenshots" + screenshot_name);
    map.put(time,file);
    run.addBreak();
    run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(350), Units.toEMU(350));
    pic.close();
    //file.delete();

    }
}

