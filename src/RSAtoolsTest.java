import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RSAtoolsTest {

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
    void encode() {
    }

    @org.junit.jupiter.api.Test
    void decode() {
    }
}