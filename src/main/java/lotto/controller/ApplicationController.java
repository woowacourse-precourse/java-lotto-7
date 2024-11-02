package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Application;
import lotto.model.Lotto;
import lotto.model.LottoPrizeMoney;
import lotto.view.ViewInput;
import lotto.view.ViewOutput;

import java.util.ArrayList;
import java.util.List;

public class ApplicationController {
    private final ViewInput viewInput;
    private final ViewOutput viewOutput;
    private final Lotto lotto;
    private final List<List<Integer>> lottoNumber = new ArrayList<>();
    private int countFirst = 0;
    private int countSecond = 0;
    private int countThird = 0;
    private int countFourth = 0;
    private int countFifth = 0;

    public ApplicationController(ViewInput viewInput, ViewOutput viewOutput, Lotto lotto) {
        this.viewInput = viewInput;
        this.viewOutput = viewOutput;
        this.lotto = lotto;
    }

    public void run() {
        int purchaseAmount = viewInput.receivePurchaseAmount();

        lottoNumberGenerator(purchaseAmount);

        List<Integer> winningNumber = viewInput.receiveWinningNumber();
        int luckyNumber = viewInput.receiveLuckyNumber();

        countWinningStatics(winningNumber, luckyNumber);

        viewOutput.printResult(countFirst, countSecond, countThird, countFourth, countFifth);
        viewOutput.printEarningRateResult(lotto.calculateEarningRate(purchaseAmount, countFirst, countSecond,countThird, countFourth, countFifth));
    }

    private void lottoNumberGenerator(int purchaseAmount){
        List<Integer> lottoNumberList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottoNumberList =  Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumber.add(lottoNumberList);
            lotto.printLottoNumbers(lottoNumberList);
        }
    }

    private void countWinningStatics(List<Integer> winningNumber, int luckyNumber) {
        for (List<Integer> subList : lottoNumber) {
            LottoPrizeMoney result = lotto.judgeWinning(subList, winningNumber, luckyNumber);
            if (result.equals(LottoPrizeMoney.FIRST)) {
                countFirst++;
            } else if (result.equals(LottoPrizeMoney.SECOND)) {
                countSecond++;
            } else if (result.equals(LottoPrizeMoney.THIRD)) {
                countThird++;
            } else if (result.equals(LottoPrizeMoney.FOURTH)) {
                countFourth++;
            } else if (result.equals(LottoPrizeMoney.FIFTH)) {
                countFifth++;
            }
        }
    }

}
