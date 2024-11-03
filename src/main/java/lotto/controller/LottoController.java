package lotto.controller;

import lotto.model.LottoModel;
import lotto.view.LottoView;

// 흐름에 따라 view와 model을 호출하는 담당
public class LottoController {
    LottoView view;
    LottoModel model;

    public LottoController(LottoView view, LottoModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        int numberOfLotto = view.inputPriceView();
        model.setUserLotto(numberOfLotto);
        view.outputUserLottoView(model.getUserLotto());
        model.setWinningNumbers(view.inputWinningNumbersView());
        int bonusNumber = view.inputBonusNumberView(model.getWinningNumbers());
        model.setBonusNumber(bonusNumber);
        model.compareLotto();
        view.outputResultView(model.getWinnerCount(), model.matchBonus());
    }
}
