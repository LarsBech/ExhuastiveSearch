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

    public static int convertTextToInt(String m) {
        int mAsEncoded = 0;
        for(int i=0; i<m.length(); i++){
            char c = m.charAt(i);
            mAsEncoded = (mAsEncoded<<(8))+c;
        }
        return mAsEncoded;
    }

    public static String convertIntToText(int c) {
        String m ="";
        while(c!=0){
            int i = 0b11111111&c;
            m =  (char)i +m;
            c = c>>8;
        }
        return m;
    }

    public static int encode(KeyPair kp, String m) {
        int c = 0;
        return c;
    }

    public static String decode(KeyPair kp, int c) {
        return "";
    }
}
