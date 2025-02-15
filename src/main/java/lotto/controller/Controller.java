package lotto.controller;

import lotto.domain.LottoCreate;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Controller {
    private WinningNumbers winningNumbersObject;
    private LottoCreate lottoCreate;
    private LottoResult lottoResult;

    public void run() {
        try {
            int purchasePrice = Input.inputPurchasePrice();
            lottoCreate = new LottoCreate(purchasePrice);

            System.out.println();
            Output.printLottos(lottoCreate);

            List<Integer> winningNumbers = Input.inputWinningNumbers();
            System.out.println();
            int bonusNumber = Input.inputBonusNumber();
            winningNumbersObject = new WinningNumbers(winningNumbers, bonusNumber);

            lottoResult = new LottoResult();
            lottoResult.calculateLottoResult(lottoCreate, winningNumbersObject);

            System.out.println();
            Output.printStatistics(lottoResult);
            Output.printYield(lottoCreate, lottoResult);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
