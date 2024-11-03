package lotto.controller;

import lotto.model.LottoCreator;
import lotto.view.InputView;

public class Controller {
    InputView inputView = new InputView();
    LottoCreator lottoCreator = new LottoCreator();

    public void chooseNumberOfLotto() {
        int numberOfLotto;
        while (true) {
            int purchasePrice = inputView.inputPurchasePrice();
            numberOfLotto = lottoCreator.chooseNumberOfLotto(purchasePrice);
            if (numberOfLotto != LottoCreator.INITIAL_NUMBER_OF_LOTTO) break;
        }
    }
}
