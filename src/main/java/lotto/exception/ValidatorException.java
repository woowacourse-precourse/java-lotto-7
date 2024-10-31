package lotto.exception;

import lotto.enums.ErrorCause;
import lotto.enums.LottoConstant;

import java.util.HashSet;
import java.util.List;

public class ValidatorException {

    // 공동 예외처리
    public static void throwIfValueIsBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(ErrorCause.INPUT_VALUE.getMessage());
        }
    }

    public static void throwIfValueIsNotNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCause.INPUT_VALUE.getMessage());
        }
    }

    public static void throwIfValueIsOutOfRange(String value) {
        int purchaseAmount = Integer.parseInt(value);
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorCause.OUT_OF_RANGE.getMessage());
        }
    }

    public static void throwIfValuesIsMismatch(List<Integer> values) {
        if (values.size() != LottoConstant.COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorCause.LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    public static void throwIfValuesIsDuplicate(List<Integer> values) {
        final HashSet<Integer> duplicationCheckSet = new HashSet<>(values);
        if (values.size() != duplicationCheckSet.size()) {
            throw new IllegalArgumentException(ErrorCause.LOTTO_NUMBER_DUPLICATION.getMessage());
        }
    }

    // 구입금액 예외처리
    public static void throwIfPurchasePriceNotMatchToUnit(String value, int lottoPrice) {
        int purchaseAmount = Integer.parseInt(value);
        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(
                    ErrorCause.PURCHASE_PRICE_UNIT.getMessage() + "(로또 1장: " + lottoPrice + "원)"
            );
        }
    }
}
