package lotto;

import controller.LottoController;
import model.Lotto;
import service.LottoService;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(lottoService, inputView, outputView);
        lottoController.start();
    }
}
