package lotto;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoController;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        LottoController lottoController = new LottoController(inputView);
        lottoController.run();
        Console.close();
    }
}
