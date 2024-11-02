package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Application;
import lotto.model.Lotto;
import lotto.view.ViewInput;
import lotto.view.ViewOutput;

import java.util.ArrayList;
import java.util.List;

public class ApplicationController {
    private final ViewInput viewInput;
    private final ViewOutput viewOutput;
    private final Lotto lotto;

    public ApplicationController(ViewInput viewInput, ViewOutput viewOutput, Lotto lotto) {
        this.viewInput = viewInput;
        this.viewOutput = viewOutput;
        this.lotto = lotto;
    }


    public void run() {
        int purchaseAmount = viewInput.receivePurchaseAmount();
        List<List<Integer>> lottoNumber = new ArrayList<>();
        List<Integer> lottoNumberList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottoNumberList =  Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumber.add(lottoNumberList);
            lotto.printLottoNumbers(lottoNumberList);
        }
        List<Integer> winningNumber = viewInput.receiveWinningNumber();
        int luckyNumber = viewInput.receiveLuckyNumber();

        for (List<Integer> subList : lottoNumber) {
            viewOutput.result(lotto.judgeWinning(subList, winningNumber, luckyNumber));
        }
    }
}
