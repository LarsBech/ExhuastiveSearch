public class Main {
    public static void main(String[] args) {
        //test
        System.out.println("NEW Hello world!");
        RSAtools rsAtools = new RSAtools();
        RSAtools.KeyPair kp = rsAtools.getKeyPair();

        int c = RSAtools.encode(kp, "Hell");
        System.out.println("\nc: "+ c);
        String m = RSAtools.decode(kp, c);
        System.out.println("\nm: "+ m);

    }
}