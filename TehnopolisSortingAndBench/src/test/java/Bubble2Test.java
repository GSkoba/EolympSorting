import org.junit.Test;

import static org.junit.Assert.*;
import static eolymp.Bubble2.Bubble2.bubble;
public class Bubble2Test {

    @Test
    public void test1(){
        assertEquals(1,bubble(new int[] {1,3,2},3));
    }

}