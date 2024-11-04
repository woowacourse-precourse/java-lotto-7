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

    /**
     * 로또 프로그램 시작시키는 메서드
     */
    public void run() {
        buyLotto();
        setWinnerLotto();
        setBonus();
        showResult();
    }

    /**
     * 로또 입력받고 올바른 입력이 나올때까지 반복
     */
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

    /**
     * 로또 당첨 번호 받아 저장
     */
    private void setWinnerLotto() {
        try {
            List<Integer> winningNum = inputHelper.getWinner();
            lottoMachine.setWinner(winningNum);
        } catch (LottoException e) {
            System.out.println(e.makeErrorMessage());
            setWinnerLotto();
        }
    }

    /**
     * 로또 보너스 번호 받아 저장
     */
    private void setBonus() {
        try {
            int bonus = inputHelper.getBonus();
            lottoMachine.setBonus(bonus);
        } catch (LottoException e) {
            System.out.println(e.makeErrorMessage());
            setBonus();
        }
    }

    /**
     * 결과 보여주는 메서드
     */
    private void showResult() {
        try {
            Result result = lottoMachine.getResult();
            outputHelper.printResult(result);
        } catch (LottoException e) {
            System.out.println(e.makeErrorMessage());
            showResult();
        }
    }
}
