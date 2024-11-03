package lotto.controller;

import lotto.exception.LottoException;
import lotto.model.LottoMachine;
import lotto.model.Result;
import lotto.view.InputHelper;
import lotto.view.OutputHelper;

import java.util.List;

public class LottoController {
    private final InputHelper inputHelper;
    private final OutputHelper outputHelper;
    private final LottoMachine lottoMachine;

    public LottoController(InputHelper inputHelper, OutputHelper outputHelper, LottoMachine lottoMachine) {
        this.inputHelper = inputHelper;
        this.outputHelper = outputHelper;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        buyLotto();
        setWinningAndBonus();
        showResult();
    }

    private void buyLotto() {
        try {
            int money = inputHelper.getPurchase();
            lottoMachine.buyLotto(money);
            outputHelper.printLotto(lottoMachine.getLottoNums());
        } catch (LottoException e) {
            System.out.println(e.makeErrorMessage());
            buyLotto();
        }
    }

    private void setWinningAndBonus() {
        try {
            List<Integer> winningNum = inputHelper.getWinner();
            int bonus = inputHelper.getBonus();

            lottoMachine.init(winningNum, bonus);
        } catch (LottoException e) {
            System.out.println(e.makeErrorMessage());
            buyLotto();
        }
    }
    
    private void showResult() {
        try {
            Result result = lottoMachine.getResult();
            outputHelper.printResult(result);
        } catch (LottoException e) {
            System.out.println(e.makeErrorMessage());
            buyLotto();
        }
    }
}
