package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

    }


    public void run() {

        int inputPrice = inputView.inputPrice();
        int numberOfPurchasedLotto = inputPrice / 1000;

        List<Lotto> generatedLottos = LottoService.generateLotto(numberOfPurchasedLotto);

        outputView.printGeneratedLottos(numberOfPurchasedLotto, generatedLottos);

        List<Integer> winningNumbers = inputView.inputWinningNumbers();

        int bonusNumber = inputView.inputBonusNumber();

        int[] result = LottoService.matchLotto(winningNumbers, bonusNumber, generatedLottos, numberOfPurchasedLotto);

        double profitRate = LottoService.calculateProfitRate(result, inputPrice);

        outputView.printResult(result, profitRate);

    }
}


