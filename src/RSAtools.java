import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class RSAtools {
    public static BigInteger phiFunction(BigInteger n){
        int phiOfN=0;
        for(int i= 0; i<n.intValue(); i++){
            BigInteger bi = BigInteger.valueOf(i);
          //  System.out.println("bi: "+bi);
          //  System.out.println("bi.gcd(BigInteger.valueOf(n)): "+bi.gcd(BigInteger.valueOf(n)));
          //  System.out.println("BigInteger.valueOf(1): " + BigInteger.valueOf(1));
          //  if(bi.gcd(n){
            //    System.out.println("bi.gcd(BigInteger.valueOf(n)): "+bi.gcd(BigInteger.valueOf(n)));
                phiOfN++;
            }
        return n;
        }
     //   return phiOfN;


    public KeyPair getKeyPair(){
        KeyPair keyPair = new KeyPair();
        return keyPair;
    }
    public class KeyPair {
        int e;
        int d;
        int n;
        public KeyPair() {
            BigInteger p = BigInteger.probablePrime(8, new Random());
            BigInteger q = BigInteger.probablePrime(8, new Random());
            n=p.intValue()*q.intValue();
            BigInteger phiOfN = p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));
            BigInteger eBig = BigInteger.valueOf(0);

            boolean notRelativPrime = true;
            while(notRelativPrime){
                eBig = BigInteger.probablePrime(6, new Random());
                if(eBig.gcd(phiOfN).intValue() == 1)
                    notRelativPrime = false;
            }

           // BigInteger x = eBig.pow(RSAtools.phiFunction(phiOfN.intValue())-1);
          //  BigInteger y = x.mod(phiOfN);
            int x = RSAtools.phiFunction(phiOfN.intValue())-1;
            int Y =42;
            BigInteger dBig =  (eBig.pow(RSAtools.phiFunction(phiOfN.intValue())-1)).mod(phiOfN) ;

            e=eBig.intValue();
            d=dBig.intValue();
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
