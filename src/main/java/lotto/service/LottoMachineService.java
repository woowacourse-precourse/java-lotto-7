package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.util.LottoParser;
import lotto.util.LottoValidator;

public class LottoMachineService {
    private final LottoMachine lottoMachine = LottoMachine.getInstance();
    private Lotto winningLotto;

    public void inputLottoPurchaseAmount(String purchaseAmount) {
        int validPrice = LottoValidator.validNumber(purchaseAmount);
        LottoValidator.validatePriceUnit(validPrice);
        lottoMachine.savePurchaseAmount(validPrice);
    }

    public void inputBonusNumber(String bonusNumber) {
        int validBonusNumber = LottoValidator.validNumber(bonusNumber);
        lottoMachine.saveBonusNumber(validBonusNumber);
    }

    public void inputWinningNumbers(String numbers) {
        List<Integer> winningNumbers = LottoParser.parsingNumber(numbers);
        lottoMachine.saveWinningNumbers(winningNumbers);
    }

    // TODO: 로또 번호들을 발급한다.

    // TODO: 사용자의 로또 번호와 비교한다.

    // TODO: 맞춘 개수와 금액을 사용자에게 전달한다.
}
