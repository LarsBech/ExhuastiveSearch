public class RSAtools {
    private class KeyPair {
        int e;
        int d;
        int n;

        public KeyPair() {

        }

        public KeyPair(int salt) {

        }

        public int getE() {
            return e;
        }
        public int getD() {
            return d;
        }
        public int getN() {
            return n;
        }
    }

    private static int convertTextToInt(String m) {
        int mAsEncoded = 0;
        return mAsEncoded;
    }

    private static String convertIntToText(int c) {
        return "";
    }

    public static int encode(KeyPair kp, String m) {
        int c = 0;
        return c;
    }

    public static String decode(KeyPair kp, int c) {
        return "";
    }
}
