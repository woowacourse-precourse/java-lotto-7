package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.service.GenerateLotto;
import lotto.service.InputService;
import lotto.service.OutputService;

import java.util.List;

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
    }
}
