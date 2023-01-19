import java.security.KeyPair;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RSAtoolsTest {

    @org.junit.jupiter.api.Test
    void phiFunctionTest() {
        assertEquals(2, RSAtools.phiFunction(3));
        assertEquals(2, RSAtools.phiFunction(4));
        assertEquals(4, RSAtools.phiFunction(5));
        assertEquals(2, RSAtools.phiFunction(6));
        assertEquals(6, RSAtools.phiFunction(7));
        assertEquals(4, RSAtools.phiFunction(8));
        assertEquals(6, RSAtools.phiFunction(9));
        assertEquals(4, RSAtools.phiFunction(10));
        assertEquals(10, RSAtools.phiFunction(11));
        assertEquals(64, RSAtools.phiFunction(192));
        assertEquals(1840,RSAtools.phiFunction(1927));
    }

    @org.junit.jupiter.api.Test
    void testKeyPair(){
        RSAtools rsAtools = new RSAtools();
        RSAtools.KeyPair keyPair = rsAtools.getKeyPair();
        //System.out.println("n: "+keyPair.getN());
     //   System.out.println("d: "+keyPair.getD());
    }

    @org.junit.jupiter.api.Test
    void convertTextToInt() {
        int i = RSAtools.convertTextToInt("Hej");
        assertEquals(4744554, i);
    }

    @org.junit.jupiter.api.Test
    void convertIntToText() {
        String s = RSAtools.convertIntToText(4744554);
        assertEquals("Hej", s);
    }


    @org.junit.jupiter.api.Test
    void convertTextToIntToText() {
        String s = "test";
        assertEquals("test",  RSAtools.convertIntToText(RSAtools.convertTextToInt(s)));

        assertEquals("a",  RSAtools.convertIntToText(RSAtools.convertTextToInt("a")));
        assertEquals("to",  RSAtools.convertIntToText(RSAtools.convertTextToInt("to")));
        assertEquals("tre",  RSAtools.convertIntToText(RSAtools.convertTextToInt("tre")));
        assertEquals("fire",  RSAtools.convertIntToText(RSAtools.convertTextToInt("fire")));

        assertEquals("23",  RSAtools.convertIntToText(RSAtools.convertTextToInt("23")));
        assertEquals("34d2",  RSAtools.convertIntToText(RSAtools.convertTextToInt("34d2")));

        assertEquals("a Xt",  RSAtools.convertIntToText(RSAtools.convertTextToInt("a Xt")));
        assertEquals("G B",  RSAtools.convertIntToText(RSAtools.convertTextToInt("G B")));

        assertEquals("",  RSAtools.convertIntToText(RSAtools.convertTextToInt("")));
        assertEquals("    ",  RSAtools.convertIntToText(RSAtools.convertTextToInt("    ")));

        assertEquals("5&",  RSAtools.convertIntToText(RSAtools.convertTextToInt("5&")));
        assertEquals("Q@ ",  RSAtools.convertIntToText(RSAtools.convertTextToInt("Q@ ")));

        assertEquals("&_ #",  RSAtools.convertIntToText(RSAtools.convertTextToInt("&_ #")));
        assertEquals("+\" {",  RSAtools.convertIntToText(RSAtools.convertTextToInt("+\" {")));

    }

    @org.junit.jupiter.api.Test
    void convertLongTextToIntToText() {

        assertEquals("a", RSAtools.convertIntToText(RSAtools.convertTextToInt("a")));
        assertEquals("to", RSAtools.convertIntToText(RSAtools.convertTextToInt("to")));
        assertEquals("tre", RSAtools.convertIntToText(RSAtools.convertTextToInt("tre")));
        assertEquals("fire", RSAtools.convertIntToText(RSAtools.convertTextToInt("fire")));
        assertEquals("~~~~", RSAtools.convertIntToText(RSAtools.convertTextToInt("~~~~")));
    }
    @org.junit.jupiter.api.Test
    void encodeAndDecode() {
        RSAtools.KeyPair kp = new RSAtools().getKeyPair();
        int c = RSAtools.encode(kp, "~~");
        String m = RSAtools.decode(kp, c);
        assertEquals("~~", m);
        /*
        for(int i=0; i<100; i++ ) {
            RSAtools.KeyPair kp = new RSAtools().getKeyPair();
            System.out.println("d: " + kp.getD()+ " n: " + kp.getN());

            int c = RSAtools.encode(kp, "a");
            String m = RSAtools.decode(kp, c);
            assertEquals("a", RSAtools.decode(kp, c));

            c = RSAtools.encode(kp, "to");
            m = RSAtools.decode(kp, c);
            assertEquals("to", RSAtools.decode(kp, c));

            c = RSAtools.encode(kp, "tr");
            m = RSAtools.decode(kp, c);
            assertEquals("tr", RSAtools.decode(kp, c));

            c = RSAtools.encode(kp, "000");
            m = RSAtools.decode(kp, c);
            assertEquals("000", RSAtools.decode(kp, c));


        }
        */

    }

}