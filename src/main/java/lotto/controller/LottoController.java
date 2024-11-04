package lotto.controller;

import lotto.model.LottoMachine;
import lotto.model.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Set;

public class LottoController {
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        try {
            int purchaseAmount = InputView.requestPurchaseAmount();
            lottoMachine.purchaseLottos(String.valueOf(purchaseAmount));

            OutputView.printPurchasedLottos(lottoMachine.getPurchasedLottos());

            // 당첨 번호 및 보너스 번호 입력 받기
            Set<Integer> winningNumbers = InputView.requestWinningNumbers();
            int bonusNumber = InputView.requestBonusNumber(winningNumbers);

            Result result = lottoMachine.calculateResults(winningNumbers, bonusNumber, purchaseAmount);
            OutputView.printResults(result);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}