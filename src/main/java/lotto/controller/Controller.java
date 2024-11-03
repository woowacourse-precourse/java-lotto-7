package lotto.controller;

import lotto.model.LottoCreator;
import lotto.model.Lottos;
import lotto.view.InputView;

public class Controller {
    InputView inputView = new InputView();


    public void purchaseLottos() {
        LottoCreator lottoCreator = new LottoCreator();
        int numberOfLotto;
        while (true) {
            int purchasePrice = inputView.inputPurchasePrice();
            numberOfLotto = lottoCreator.chooseNumberOfLotto(purchasePrice);
            if (numberOfLotto != LottoCreator.INITIAL_NUMBER_OF_LOTTO) break;
        }
        Lottos lottos = new Lottos(numberOfLotto);
    }
}
