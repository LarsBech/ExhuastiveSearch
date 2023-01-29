import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
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
*/
        @org.junit.jupiter.api.Test
        void primeFactorizeTest() {

            ArrayList<BigInteger> pf= new ArrayList<>();
            pf.add(new BigInteger("1"));
            pf.add(new BigInteger("2"));
            pf.add(new BigInteger("2"));
            pf.add(new BigInteger("2"));
      //      assertTrue(pf.equals(RSAtools.primeFactorize(new BigInteger("8"))));

            ArrayList<BigInteger> pf1= new ArrayList<>();
            pf1.add(new BigInteger("1"));
            pf1.add(new BigInteger("3"));
            pf1.add(new BigInteger("3"));
       //     assertTrue(pf1.equals(RSAtools.primeFactorize(new BigInteger("9"))));

            ArrayList<BigInteger> pf3= new ArrayList<>();
            pf3.add(new BigInteger("1"));
            pf3.add(new BigInteger("2"));
            pf3.add(new BigInteger("5"));
       //     assertTrue(pf3.equals(RSAtools.primeFactorize(new BigInteger("10"))));

            ArrayList<BigInteger> pf4= new ArrayList<>();
            pf4.add(new BigInteger("1"));
            pf4.add(new BigInteger("2"));
            pf4.add(new BigInteger("2"));
            pf4.add(new BigInteger("3"));
      //      assertTrue(pf4.equals(RSAtools.primeFactorize(new BigInteger("12"))));

            ArrayList<BigInteger> pf5= new ArrayList<>();
            pf5.add(new BigInteger("1"));
            pf5.add(new BigInteger("2"));
            pf5.add(new BigInteger("3"));
            pf5.add(new BigInteger("3"));
            pf5.add(new BigInteger("3"));
            pf5.add(new BigInteger("5"));
       //     assertTrue(pf5.equals(RSAtools.primeFactorize(new BigInteger("270"))));

            ArrayList<BigInteger> pf2= new ArrayList<>();
            pf2.add(new BigInteger("1"));
            assertTrue(pf2.equals(RSAtools.primeFactorize(new BigInteger("13"))));
            assertTrue(pf2.equals(RSAtools.primeFactorize(new BigInteger("40013"))));


        }
/*
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
    void convertTextToBigInt() {
        BigInteger i = RSAtools.convertTextToBigInt("Hej");
        assertEquals(BigInteger.valueOf(4744554), i);

        i = RSAtools.convertTextToBigInt("HejK");
        assertEquals(BigInteger.valueOf(1214605899), i);

        i = RSAtools.convertTextToBigInt("HejK4");
        BigInteger e = new BigInteger("310939110196");
        assertEquals(e, i);

        i = RSAtools.convertTextToBigInt("HejK4a");
        e = new BigInteger("79600412210273");
        assertEquals(e, i);
    }

    @org.junit.jupiter.api.Test
    void convertBigIntToText() {
        String s = RSAtools.convertBigIntToText(new BigInteger("4744554"));
        assertEquals("Hej", s);

         s = RSAtools.convertBigIntToText(new BigInteger("1214605899"));
        assertEquals("HejK", s);

         s = RSAtools.convertBigIntToText(new BigInteger("310939110196"));
        assertEquals("HejK4", s);

         s = RSAtools.convertBigIntToText(new BigInteger("79600412210273"));
        assertEquals("HejK4a", s);
    }


    @org.junit.jupiter.api.Test
    void convertTextToIntToText() {
        String s = "test";
        assertEquals("test", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt(s)));

        assertEquals("a", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("a")));
        assertEquals("to", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("to")));
        assertEquals("tre", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("tre")));
        assertEquals("fire", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("fire")));

        assertEquals("23", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("23")));
        assertEquals("34d2", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("34d2")));

        assertEquals("a Xt", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("a Xt")));
        assertEquals("G B", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("G B")));

        assertEquals("asdfdd dda s444DDDD", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("asdfdd dda s444DDDD")));
        assertEquals("    ", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("    ")));
        assertEquals(" ", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt(" ")));
        assertEquals("5&", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("5&")));
        assertEquals("Q@ ", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("Q@ ")));

        assertEquals("&_ #", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("&_ #")));
        assertEquals("+\" {", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("+\" {")));

        assertEquals("a", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("a")));
        assertEquals("to", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("to")));
        assertEquals("tre", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("tre")));
        assertEquals("fire", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("fire")));
        assertEquals("~~~~", RSAtools.convertBigIntToText(RSAtools.convertTextToBigInt("~~~~")));
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