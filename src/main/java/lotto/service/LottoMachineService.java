package lotto.service;

import lotto.domain.LottoMachine;
import lotto.util.LottoValidator;

public class LottoMachineService {
    private final LottoMachine lottoMachine = LottoMachine.getInstance();

    public void inputLottoPurchaseAmount(String purchaseAmount) {
        int price = LottoValidator.validNumber(purchaseAmount);
        LottoValidator.validatePriceUnit(price);
        lottoMachine.savePurchaseAmount(price);
    }

    // TODO: 보너스 번호를 입력받는다.

    // TODO: 로또 번호들을 발급한다.

    // TODO: 사용자의 로또 번호와 비교한다.

    // TODO: 맞춘 개수와 금액을 사용자에게 전달한다.
}
