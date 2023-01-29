import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class RSAtools {

    public static ArrayList<Integer> primeFactorize(int n) {
        ArrayList<Integer> pf = new ArrayList<>();
        pf.add(1);
        int factor = 2;
        int rm = n;

        while (factor <= rm ) {
            if (rm % factor == 0 && factor!=n) {
              pf.add(factor);
                rm = rm / factor;
                factor--;
            }
            factor++;
        }
        return pf;
    }

    public static int phiFunctionEfficient(int n) {
        int phiOfN=1;
        ArrayList<Integer> pf = primeFactorize(n);
        if(pf.size()==1)
            return n-1;

        for(int i=1; i<pf.size(); i++){
            int factor = pf.get(i);
            int nrOfOcurrences = 1;
            while(i<pf.size()-1 && factor==pf.get(i+1)){
                nrOfOcurrences++;
                i++;
            }
            if(nrOfOcurrences==1){
                phiOfN = phiOfN * (factor-1);
            }else{

                phiOfN = phiOfN * ((int)Math.pow(factor, nrOfOcurrences) - (int)Math.pow(factor, nrOfOcurrences-1));
            }
            if (phiOfN % 100 == 0) {
                System.out.println("phiOfN: " + phiOfN);
            }
        }
        return phiOfN;
    }

    public static int phiFunction(int n) {
        int phiOfN = 0;
        for (int i = 1; i < n; i++) {
            BigInteger bi = BigInteger.valueOf(i);
            if (bi.gcd(BigInteger.valueOf(n)).equals(BigInteger.valueOf(1))) {
                phiOfN++;
            }
            if (phiOfN % 100 == 0) {
                System.out.println("phiOfN: " + phiOfN);
            }
        }
        return phiOfN;
    }

    public static int fastExpAlt(int base, int exponent, int modulus){
        ArrayList<Integer> exponentList = primeFactorize(exponent);
        BigInteger baseBig = BigInteger.valueOf(base);

        if(exponentList.size()==1) {
            return baseBig.pow(exponent).mod(BigInteger.valueOf(modulus)).intValue();
        }

        BigInteger r = baseBig.pow(exponentList.get(1)).mod(BigInteger.valueOf(modulus));

        for(int i=2; i<exponentList.size(); i++){
            // System.out.println("primfactor: "+ exponentList.get(i));
            r = r.pow(exponentList.get(i)).mod(BigInteger.valueOf(modulus));
        }
        return r.intValue();
    }

    public static int fastExp(int base, int exponent, int modulus){
        ArrayList<Integer> exponentList = primeFactorize(exponent);
        BigInteger baseBig = BigInteger.valueOf(base);

        if(exponentList.size()==1) {
            return baseBig.pow(exponent).mod(BigInteger.valueOf(modulus)).intValue();
        }

        BigInteger r = baseBig.pow(exponentList.get(1)).mod(BigInteger.valueOf(modulus));

        for(int i=2; i<exponentList.size(); i++){
           // System.out.println("primfactor: "+ exponentList.get(i));
            r = r.pow(exponentList.get(i)).mod(BigInteger.valueOf(modulus));
        }
        return r.intValue();
    }


    public KeyPair getKeyPair() {
        return new KeyPair();
    }

    public class KeyPair {
        int e;
        int d;
        int n;

        public KeyPair() {
            //Java max size int: 2.147.483.647
            //Min size for n:    2.122.219.134 in order to represent "~~~~" (the largest printable 4 byte ascii string)
            //                     541.556.023
            e=(13);
            int  p = (39971);
            int q =(53359);
            n=p*q;
            int  phiOfN = (p-1)*(q-1);

            //BigInteger dBig = (eBig.pow(RSAtools.phiFunctionEfficient(phiOfN.intValue()) - 1)).mod(phiOfN);

            d = fastExp( e,phiFunctionEfficient( phiOfN)-1, phiOfN);

            /*
            boolean notRelativPrime = true;
            while (notRelativPrime) {
                BigInteger p = BigInteger.probablePrime(8, new Random());
                BigInteger q = BigInteger.probablePrime(8, new Random());
                n = p.intValue() * q.intValue();
                phiOfN = p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));

                if (eBig.gcd(phiOfN).intValue() == 1)
                    notRelativPrime = false;
            }
*/


         //   System.out.println("phiOfN: " + phiOfN.intValue());
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

    //Max 4 ascii chars
    public static int convertTextToInt(String m) {
        int mAsEncoded = 0;
        for (int i = 0; i < m.length(); i++) {
            char c = m.charAt(i);
            mAsEncoded = (mAsEncoded << (8)) + c;
        }
        return mAsEncoded;
    }

    //Max 4 ascii chars
    public static String convertIntToText(int c) {
        String m = "";
        while (c != 0) {
            int i = 0b11111111 & c;
            m = (char) i + m;
            c = c >> 8;
        }
        return m;
    }

    //Max 2 ascii chars
    public static int encode(KeyPair kp, String m) {
        int mAsInt = RSAtools.convertTextToInt(m);
     //   System.out.println("\nm: \"" + m + "\"   mAsInt: " + mAsInt);
     //   System.out.println("e: " + kp.getE() + "    d: " + kp.getD() + "    n: " + kp.getN());
        //System.out.println("c = ((int)Math.pow(mAsInt, kp.getE())) % kp.getN(): " + ((int)Math.pow(mAsInt, kp.getE())) % kp.getN());
        BigInteger mBig = BigInteger.valueOf(mAsInt);
        BigInteger nBig = BigInteger.valueOf(kp.getN());
        BigInteger cBig = mBig.pow(kp.getE()).mod(nBig);
    //    System.out.println("c: " + cBig.intValue());
        return cBig.intValue();
    }

    //Max 2 ascii chars
    public static String decode(KeyPair kp, int c) {
        //  System.out.println("\nc: "+c+"   d: " + kp.getD());
        //  System.out.println("mAsInt = ((int)Math.pow(c, kp.getD())) % kp.getN(): "+ ((int)Math.pow(c, kp.getD())) % kp.getN());
        //BigInteger cBig = BigInteger.valueOf(c);
        //BigInteger nBig = BigInteger.valueOf(kp.getN());
       // BigInteger mAsBig = cBig.pow(kp.getD()).mod(nBig);
        int m = fastExp(c, kp.getD(),kp.getN() );


        //int mAsInt = ((int)Math.pow(c, kp.getD())) % kp.getN();
    //    System.out.println("mAsInt: " + mAsBig.intValue());
    //    System.out.println("m: " + RSAtools.convertIntToText(mAsBig.intValue()));
        return RSAtools.convertIntToText(m);
    }
}
