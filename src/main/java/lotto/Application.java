package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            LottoService lottoService = new LottoService();
            LottoController lottoController = new LottoController(inputView, outputView, lottoService);
            lottoController.run();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());//output 이 할일을 왜 너가 하고있니... 로깅이라고 치자...
        }
    }
}
