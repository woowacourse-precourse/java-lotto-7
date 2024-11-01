package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoPurchaseInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoPurchaseInputView lottoPurchaseInputView = new LottoPurchaseInputView();
        LottoController lottoController = new LottoController(lottoPurchaseInputView);
        lottoController.run();
    }
}
