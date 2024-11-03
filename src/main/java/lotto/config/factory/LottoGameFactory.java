package lotto.config.factory;

import lotto.game.LottoGame;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoGameFactory {

    public static LottoGame create() {
        return new LottoGame(LottoControllerFactory.create(), lottoInputView(), lottoOutputView());
    }

    private static LottoInputView lottoInputView() {
        return new LottoInputView();
    }

    public static LottoOutputView lottoOutputView() {
        return new LottoOutputView();
    }
}
