package lotto.validator;

import java.util.List;

public class LottoValidator {

    private final Validator<List<Integer>> lottoNumberValidator = new LottoNumberValidator();
    private final Validator<Integer> bonusNumberValidator = new BonusNumberValidator();
    private final Validator<Integer> purchaseAmountValidator = new PurchaseAmountValidator();

    public void validateLottoNumbers(List<Integer> numbers) {
        lottoNumberValidator.validate(numbers);
    }

    public void validateBonusNumber(int bonusNumber) {
        bonusNumberValidator.validate(bonusNumber);
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        purchaseAmountValidator.validate(purchaseAmount);
    }
}
