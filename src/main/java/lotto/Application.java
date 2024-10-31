package lotto;

import lotto.game.LottoGame;

public class Application {
    public static void main(String[] args) {
        try {
            new LottoGame().start();
        }catch(IllegalArgumentException e) {
            e.getMessage();
        }
    }
}