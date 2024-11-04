package lotto.controller;

import lotto.domain.*;
import lotto.service.*;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputService inputService = new InputService();
    private final OutputService outputService = new OutputService();
    private final GenerateLotto generateLotto = new GenerateLotto();
    public void run() {
        outputService.requestPay();
        Money money = new Money(inputService.inputPaidMoney());
        int amountLotto = money.getAmount();
        List<Lotto> purchasedLotto = generateLotto.generateLottoNumbers(amountLotto);

        outputService.requestWinningNumbers();
        WinningNumbers winningNumbers = inputService.inputWinningNumbers();

        outputService.requestBonusNumber();
        BonusNumber bonusNumber = inputService.inputBonusNumber(winningNumbers);

        outputService.moveToShowPrize();
        PrizeSettle prizeSettle = new PrizeSettle(
            purchasedLotto, winningNumbers.getNumbers(), bonusNumber.getNumber()
        );
        Map<Prize, Integer> resultPrizeSettle = prizeSettle.getResultCounts();
        outputService.showResultLotto(resultPrizeSettle);

        RateOfReturn rateOfReturn = new RateOfReturn(resultPrizeSettle);
        double rate = rateOfReturn.calculateRateOfReturn(money.getMoney());
        outputService.showRateOfReturn(rate);
    }
}
