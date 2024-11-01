package lotto.controller;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        outputView.showMoneyInputComments();
        int money = inputView.getMoneyFromUser();

        outputView.showLottoWinningNumberInputComments();
        List<Integer> lottoWinningNumber = inputView.getLottoWinningNumberFromUser();

        outputView.showLottoBonusNumberInputComments();
        int lottoBonusNumber = inputView.getLottoBonusNumberFromUser();
    }

}
