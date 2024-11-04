package lotto;

import lotto.config.LottoConfiguration;
import lotto.input.InputHandler;
import lotto.input.InputParser;
import lotto.service.LottoGame;
import lotto.utils.LottoUtils;

public class Application {
    public static void main(String[] args) {
        try {
            InputHandler inputHandler = new InputHandler();
            InputParser inputParser = new InputParser();
            LottoConfiguration configuration = new LottoConfiguration(inputHandler, inputParser);
            LottoGame lottoGame = new LottoGame(configuration, new LottoUtils());
            lottoGame.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}