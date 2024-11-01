package lotto;
import lotto.LottoGame;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.start();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
