package lotto.view;

import lotto.util.NumberConverter;
import lotto.view.lottoPurchaseView.LottoPurchaseInputView;
import lotto.view.winningLottoView.WinningLottoInputView;

public class LottoInputViewFactory {
    public LottoPurchaseInputView createLottoPurchaseInputView(InputProvider inputProvider, NumberConverter numberConverter) {
        return new LottoPurchaseInputView(inputProvider, numberConverter);
    }

    public WinningLottoInputView createWinningLottoInputView(InputProvider inputProvider, NumberConverter numberConverter) {
        return new WinningLottoInputView(inputProvider, numberConverter);
    }
}
