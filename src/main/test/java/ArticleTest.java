package PACKAGE_NAME;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Do
 * @package PACKAGE_NAME
 * @name ArticleTest
 * @date 2017/4/12
 * @time 13:00
 */
public class ArticleTest {

    @Test
    public void getTime(){
        for (int i = 0; i < 20; i++) {
            System.out.println(System.currentTimeMillis());
        }
    }

    @Test
    public void timeTest(){
        String yyyyMMdd = new SimpleDateFormat("yyyyMMdd").format(new Date());
        for (int i = 0; i < 10; i++) {
            int random = new Random().nextInt(899)+100;
            System.out.println(yyyyMMdd+random);
        }

    }
}
