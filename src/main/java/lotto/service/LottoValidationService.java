package lotto.service;

import static lotto.common.Constants.LOTTO_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.validator.PurchaseAmountValidator;
import lotto.util.validator.WinningLottoValidator;

public class LottoValidationService {
    private final PurchaseAmountValidator purchaseAmountValidator;
    private final WinningLottoValidator winningLottoValidator;

    public LottoValidationService() {
        this.purchaseAmountValidator = new PurchaseAmountValidator();
        this.winningLottoValidator = new WinningLottoValidator();
    }

    public int validatePurchaseAmount(String input) {
        purchaseAmountValidator.validate(input);
        return Integer.parseInt(input);
    }

    public List<Integer> validateWinningLotto(String input) {
        winningLottoValidator.validate(input);
        return Arrays.stream(input.split(LOTTO_SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}