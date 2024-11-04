package lotto.controller;

import lotto.domain.*;
import lotto.service.*;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputService inputService = new InputService();
    private final OutputService outputService = new OutputService();
    private final GenerateLotto generateLotto = new GenerateLotto();
    private Money money;
    public void run() {
        int amountLotto = purchaseLottoProcess();
        List<Lotto> purchasedLotto = generateLotto.generateLottoNumbers(amountLotto);
        WinningNumbers winningNumbers = drawWinningNumbersProcess();
        BonusNumber bonusNumber = drawBonusNumberProcess(winningNumbers);
        Map<Prize, Integer> resultPrizeSettle = prizeSettleProcess(
                purchasedLotto, winningNumbers, bonusNumber
        );
        double rate = calculateRateOfReturnProcess(resultPrizeSettle);
        outputService.showRateOfReturn(rate);
    }

    private int purchaseLottoProcess() {
        outputService.requestPay();
        money = new Money(inputService.inputPaidMoney());
        return money.getAmount();
    }

    private WinningNumbers drawWinningNumbersProcess() {
        outputService.requestWinningNumbers();
        return inputService.inputWinningNumbers();
    }

    private BonusNumber drawBonusNumberProcess(WinningNumbers winningNumbers) {
        outputService.requestBonusNumber();
        return inputService.inputBonusNumber(winningNumbers);
    }

    private Map<Prize, Integer> prizeSettleProcess(List<Lotto> purchasedLotto,
                                                   WinningNumbers winningNumbers,
                                                   BonusNumber bonusNumber) {
        outputService.moveToShowPrize();
        PrizeSettle prizeSettle = new PrizeSettle(
            purchasedLotto, winningNumbers.getNumbers(), bonusNumber.getNumber()
        );
        return prizeSettle.getResultCounts();
    }

    private double calculateRateOfReturnProcess(Map<Prize, Integer> resultPrizeSettle) {
        outputService.showResultLotto(resultPrizeSettle);
        RateOfReturn rateOfReturn = new RateOfReturn(resultPrizeSettle);
        return rateOfReturn.calculateRateOfReturn(money.getMoney());
    }
}
