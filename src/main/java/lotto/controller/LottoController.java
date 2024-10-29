package lotto.controller;

import java.util.List;
import lotto.view.InputView;

public class LottoController {

    public void runLotto() {
        int lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
        String wonLottoNumbersString = InputView.inputWonLottoNumbers();
        List<Integer> parsedWonLottoNumbers = InputView.parseWonLottoNumbers(wonLottoNumbersString);
    }
}
