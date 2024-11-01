package lotto.controller;

import java.util.List;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.WinningNumbersInputView;

public class LottoDrawingController {
    private final Lottos lottos;
    private final LottoPurchase lottoPurchase;

    public LottoDrawingController(Lottos lottos, LottoPurchase lottoPurchase) {
        this.lottos = lottos;
        this.lottoPurchase = lottoPurchase;
    }

    public void start() {
        WinningNumbers winningNumbers = setWinningNumbers();
    }

    private WinningNumbers setWinningNumbers() {
        WinningNumbersInputView winningNumbersInputView = new WinningNumbersInputView();
        winningNumbersInputView.printWinningNumbersInputGuide();
        List<Integer> winningNumbers = winningNumbersInputView.getWinningNumbers();

        winningNumbersInputView.printBonusNumberInputGuide();
        int bonusNumber = winningNumbersInputView.getBonusNumber();

        return new WinningNumbers(winningNumbers, bonusNumber);
    }
}
