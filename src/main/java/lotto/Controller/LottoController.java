package lotto.Controller;

import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class LottoController {

    private final InputView input;
    private final OutputView output;

    public LottoController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        int lottoAmount = input.requestPurchasePrice();
        output.printPurchasedLotto(lottoAmount);
        List<Integer> getWinningNumbers = input.requestNumbers();
        int bonusNumber = input.requestBonusNumber();

    }
}
