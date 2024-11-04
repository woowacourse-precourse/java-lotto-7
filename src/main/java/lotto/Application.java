package lotto;

import controller.LottoController;
import service.LottoService;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new LottoController(new InputView(), new OutputView(), new LottoService()).run();
    }
}
