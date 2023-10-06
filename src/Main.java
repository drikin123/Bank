public class Main {
    public static void main(String[] args) {
        Compte c = new Compte();
        System.out.println(c);
        c.soldeUp("achat ps5",500.99);
        System.out.println(c);
        c.soldeDown("facture loyer",800);
        System.out.println(c);
        c.soldeUp("virement",1000);
        System.out.println(c);
    }
}