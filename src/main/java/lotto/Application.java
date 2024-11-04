package lotto;

import controller.LottoController;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new LottoController(new InputView()).run();
    }
}
