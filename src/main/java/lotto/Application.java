package lotto;


import lotto.controller.LottoController;
import lotto.model.WinningNumbers;
import lotto.model.service.LottoService;
import lotto.model.service.WinningNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        WinningNumbers winningNumbers = new WinningNumbers();

        WinningNumbersService winningNumbersService = new WinningNumbersService(winningNumbers, new InputView());

        LottoController lottoController = new LottoController(new InputView(), new OutputView(), new LottoService(), winningNumbersService);

        lottoController.run();
    }
}
