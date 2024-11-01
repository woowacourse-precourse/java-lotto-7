package lotto.controller;

import java.util.List;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run(){
        int money = inputView.getMoneyFromUser();
        List<Integer> lottoWinningNumber = inputView.getLottoWinningNumberFromUser();
        int lottoBonusNumber = inputView.getLottoBonusNumberFromUser();
    }

}
