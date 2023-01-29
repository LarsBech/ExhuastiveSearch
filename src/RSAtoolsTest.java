import java.math.BigInteger;
import java.security.KeyPair;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RSAtoolsTest {
/*
    @org.junit.jupiter.api.Test
    void phiFunctionEfficientTest() {
      assertEquals(2, RSAtools.phiFunctionEfficient(3));
        assertEquals(4, RSAtools.phiFunctionEfficient(5));
        assertEquals(22, RSAtools.phiFunctionEfficient(23));

        assertEquals(2, RSAtools.phiFunctionEfficient(6));
        assertEquals(4, RSAtools.phiFunctionEfficient(8));

        assertEquals(8, RSAtools.phiFunctionEfficient(15));
        assertEquals(8, RSAtools.phiFunctionEfficient(24));
        assertEquals(16, RSAtools.phiFunctionEfficient(32));
        assertEquals(20, RSAtools.phiFunctionEfficient(33));

        assertEquals(486570240, RSAtools.phiFunctionEfficient(2132719260));

    }

    @org.junit.jupiter.api.Test
    void fastExpTest() {
        int b=37; int exp = 36; int modulus = 117;
        assertEquals(1, RSAtools.fastExp(b, exp, modulus));

        b=22; exp= 17; modulus =224;
        assertEquals(64, RSAtools.fastExp(b, exp, modulus));

        b=22; exp= 38; modulus =224;
        assertEquals(64, RSAtools.fastExp(b, exp, modulus));

        b=22; exp= 38; modulus =227;
        assertEquals(62, RSAtools.fastExp(b, exp, modulus));

        b=17; exp= 31; modulus =224;
        assertEquals(17, RSAtools.fastExp(b, exp, modulus));

        b=17; exp= 31; modulus =111;
        assertEquals(2, RSAtools.fastExp(b, exp, modulus));

    }

    @org.junit.jupiter.api.Test
    void primeFactorizeTest() {

        ArrayList<Integer> pf= new ArrayList<>();
        pf.add(1);
        pf.add(2);
        pf.add(2);
        pf.add(2);
        assertTrue(pf.equals(RSAtools.primeFactorize(8)));

        ArrayList<Integer> pf1= new ArrayList<>();
        pf1.add(1);
        pf1.add(3);
        pf1.add(3);
        assertTrue(pf1.equals(RSAtools.primeFactorize(9)));

        ArrayList<Integer> pf3= new ArrayList<>();
        pf3.add(1);
        pf3.add(2);
        pf3.add(5);
        assertTrue(pf3.equals(RSAtools.primeFactorize(10)));

        ArrayList<Integer> pf4= new ArrayList<>();
        pf4.add(1);
        pf4.add(2);
        pf4.add(2);
        pf4.add(3);
        assertTrue(pf4.equals(RSAtools.primeFactorize(12)));

        ArrayList<Integer> pf5= new ArrayList<>();
        pf5.add(1);
        pf5.add(2);
        pf5.add(3);
        pf5.add(3);
        pf5.add(3);
        pf5.add(5);
        assertTrue(pf5.equals(RSAtools.primeFactorize(270)));

        ArrayList<Integer> pf2= new ArrayList<>();
        pf2.add(1);
        assertTrue(pf2.equals(RSAtools.primeFactorize(13)));
        assertTrue(pf2.equals(RSAtools.primeFactorize(40013)));


    }

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
*/
    @org.junit.jupiter.api.Test
    void convertTextToInt() {
        BigInteger i = RSAtools.convertTextToInt("Hej");
        assertEquals(BigInteger.valueOf(4744554), i);
    }

    @org.junit.jupiter.api.Test
    void convertIntToText() {
      //  String s = RSAtools.convertIntToText(4744554);
      //  assertEquals("Hej", s);
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

    /*
    @org.junit.jupiter.api.Test
    void encodeAndDecodeTest() {
        RSAtools.KeyPair kp = new RSAtools().getKeyPair();
        int c = RSAtools.encode(kp, "~~");
        String m = RSAtools.decode(kp, c);
      //  assertEquals("~~", m);

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


    }*/

}