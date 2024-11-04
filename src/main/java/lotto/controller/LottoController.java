package lotto.controller;

import lotto.service.LottoService;
import lotto.util.*;
import lotto.view.InputProvider;
import lotto.view.LottoInputViewFactory;
import lotto.view.LottoOutputViewFactory;
import lotto.view.lottoPurchaseView.LottoPurchaseInputView;
import lotto.view.winningLottoView.*;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(InputProvider inputProvider, LottoInputViewFactory lottoInputViewFactory, LottoOutputViewFactory outputViewFactory) {
        NumberConverter numberConverter = new NumberConverter();
        LottoPurchaseInputView lottoPurchaseInputView = lottoInputViewFactory.createLottoPurchaseInputView(inputProvider, numberConverter);
        WinningLottoInputView winningLottoInputView = lottoInputViewFactory.createWinningLottoInputView(inputProvider, numberConverter);

        this.lottoService = new LottoService(lottoPurchaseInputView, winningLottoInputView,
                outputViewFactory.createLottoPurchaseOutputView(),
                outputViewFactory.createWinningLottoOutputView(),
                outputViewFactory.createLottoProfitOutputView());
    }

    public void startLotto() {
        lottoService.startLotto();
    }

}