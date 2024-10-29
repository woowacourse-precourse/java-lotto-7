package lotto;

public class Application {
    public static void main(String[] args) {
        while (true) {
            try {
                new LottoGame().start();
                break;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}



