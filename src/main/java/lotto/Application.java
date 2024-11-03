package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
