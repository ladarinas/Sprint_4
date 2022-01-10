public class Praktikum {
    static String fullName = "имя фамилия";

    public static void main(String[] args) {

        Account account = new Account(fullName);
        account.checkNameToEmboss();
        System.out.println(account.checkNameToEmboss());
    }
}
