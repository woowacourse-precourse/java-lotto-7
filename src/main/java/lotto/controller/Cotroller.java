package lotto.controller;

import java.util.ArrayList;
import lotto.Lotto;
import lotto.util.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Cotroller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoManager lottoManager = new LottoManager();
    ArrayList<Lotto> lottos;

    public void start(){

    }

    public void purchaseProcess(){
        int amount = inputView.getPurchaseAmount();
        lottos = lottoManager.purchaseLotto(amount);
    }
}
