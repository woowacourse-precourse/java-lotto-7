package lotto;

import lotto.controller.LottoGame;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();

        try {
            LottoGame lottoGame = new LottoGame(input, output);
            lottoGame.play();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
