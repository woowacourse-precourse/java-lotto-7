package controller;

import model.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private Integer cost;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public MyLotto myLotto;
    public Lotto winningLotto;
    public List<Prize> resultPrize;
    public LottoResult lottoResult;

    public void run() {

        try {
            this.getInputs();
            this.runLotto();
            this.outputResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private void getInputs() {
        this.cost = InputView.inputCost();
        this.winningNumbers = InputView.inputWinningNumbers();
        this.bonusNumber = InputView.inputBonusNumber();
    }

    private void runLotto() {
        initializeLotto();
        calculatePrizes();
        createResult();
    }

    private void initializeLotto() {
        this.myLotto = new MyLotto(this.cost / 1000);
        this.winningLotto = new Lotto(this.winningNumbers);
        this.resultPrize = new ArrayList<>();
    }

    private void calculatePrizes() {
        for (Lotto lotto : this.myLotto.getMyLotto()) {
            Prize prize = determinePrize(lotto);
            resultPrize.add(prize);
        }
    }

    private Prize determinePrize(Lotto lotto) {
        int matchCount = LottoMatcher.compareNumbers(lotto, this.winningLotto);
        boolean bonusMatch = LottoMatcher.compareBonusNumber(lotto, this.bonusNumber);
        return Prize.prizeOf(matchCount, bonusMatch);
    }

    private void createResult() {
        this.lottoResult = new LottoResult(this.resultPrize);
    }

    private void outputResult() {
        OutputView.outputMyLotto(this.myLotto.getMyLottoForPrint());
        OutputView.outputPrizeResult(this.lottoResult.getWinningResult());
        OutputView.outputWinningRate(this.lottoResult.calculateWinningRate());
    }
}
