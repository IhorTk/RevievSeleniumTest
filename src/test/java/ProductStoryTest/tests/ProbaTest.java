package ProductStoryTest.tests;

import ProductStoryTest.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;

public class ProbaTest {
 @Test
    public void getPropertys(){
     int time= (int) Long.parseLong(ConfigurationReader.get("timeout"));
     System.out.println("time = " + time);
 }
}
