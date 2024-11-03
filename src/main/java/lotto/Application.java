package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputView()
        );
        lottoController.run();
        Console.close();
    }
}
