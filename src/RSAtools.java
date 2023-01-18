import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class RSAtools {
    public static int phiFunction(int n){
        int phiOfN=0;
        for(int i=1; i<n; i++){
            BigInteger bi = BigInteger.valueOf(i);
          //  System.out.println("bi: "+bi);
          //  System.out.println("bi.gcd(BigInteger.valueOf(n)): "+bi.gcd(BigInteger.valueOf(n)));
          //  System.out.println("BigInteger.valueOf(1): " + BigInteger.valueOf(1));
            if(bi.gcd(BigInteger.valueOf(n)).equals(BigInteger.valueOf(1))){
            //    System.out.println("bi.gcd(BigInteger.valueOf(n)): "+bi.gcd(BigInteger.valueOf(n)));
                phiOfN++;
            }
        }
        return phiOfN;
    }
    private class KeyPair {
        int e;
        int d;
        int n;


        public KeyPair() {
            int p = BigInteger.probablePrime(16, new Random()).intValue();
            int q = BigInteger.probablePrime(16, new Random()).intValue();
            n=p*q;
            e= 13;
            //d =
            int phi = (p-1)*(q-1);
            //d = Math.pow(e, )

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
