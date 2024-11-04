package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame game = new LottoGame();
            game.play();
        } finally {
            Console.close();
        }
    }
}
