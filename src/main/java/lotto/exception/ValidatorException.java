package lotto.exception;

import lotto.enums.ErrorCause;
import lotto.enums.LottoConstant;

import java.util.HashSet;
import java.util.List;

public class ValidatorException {

    // 구입금액 예외처리
    public static void throwIfPurchasePriceIsBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(ErrorCause.INPUT_VALUE.getMessage());
        }
    }

    public static void throwIfPurchasePriceIsNotNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCause.INPUT_VALUE.getMessage());
        }
    }

    public static void throwIfPurchasePriceNotMatchToUnit(String value, int lottoPrice) {
        int purchaseAmount = Integer.parseInt(value);
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(
                    ErrorCause.PURCHASE_PRICE_UNIT.getMessage() + "(로또 1장: " + lottoPrice + "원)"
            );
        }
    }

    public static void throwIfPurchasePriceIsZeroOrNegative(String value) {
        int purchaseAmount = Integer.parseInt(value);
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(
                    ErrorCause.PURCHASE_PRICE_CANNOT_BE_ZERO_OR_NEGATIVE.getMessage());
        }
    }

    // 로또 예외처리
    public static void throwIfLottoNumberCountIsMismatch(List<Integer> numbers) {
        if(numbers.size() != LottoConstant.COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorCause.LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public static void throwIfLottoNumberIsDuplicate(List<Integer> numbers) {
        final HashSet<Integer> duplicationCheckSet = new HashSet<>(numbers);
        if(numbers.size() != duplicationCheckSet.size()) {
            throw new IllegalArgumentException(ErrorCause.LOTTO_NUMBER_DUPLICATION.getMessage());
        }
    }
}
