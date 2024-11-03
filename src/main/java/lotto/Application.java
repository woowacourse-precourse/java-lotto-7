package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            new LottoStore().run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}