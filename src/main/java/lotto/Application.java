package lotto;


import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.parser.InputParser;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView(new InputParser());
            OutputView outputView = new OutputView();
            LottoService lottoService = new LottoService();
            LottoController lottoController = new LottoController(inputView, outputView, lottoService);
            lottoController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
