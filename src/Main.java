public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int c =RSAtools.convertTextToInt("Hej");
        System.out.println("\nText: "+ RSAtools.convertIntToText(c));
        RSAtools rsAtools = new RSAtools();
        rsAtools.getKeyPair();
    }
}