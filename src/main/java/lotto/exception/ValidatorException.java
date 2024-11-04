package lotto.exception;

import lotto.collection.WinningNumber;
import lotto.enums.ErrorCause;
import lotto.enums.LottoConstant;

import java.util.HashSet;
import java.util.List;

public class ValidatorException {

    // 공동 예외처리
    public static void throwIfValueIsNotNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCause.INPUT_VALUE.getMessage());
        }
    }

    public static void throwIfValueIsOutOfRange(String value) {
        int purchasePrice = Integer.parseInt(value);
        if (purchasePrice < LottoConstant.START_INCLUSIVE.getValue() ||
                purchasePrice > LottoConstant.END_INCLUSIVE.getValue()) {
            throw new IllegalArgumentException(ErrorCause.OUT_OF_RANGE.getMessage());
        }
    }

    public static void throwIfValuesIsMismatch(List<Integer> values) {
        if (values.size() != LottoConstant.COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorCause.NUMBER_COUNT.getMessage());
        }
    }

    public static void throwIfValuesIsDuplicate(List<Integer> values) {
        final HashSet<Integer> duplicationCheckSet = new HashSet<>(values);
        if (values.size() != duplicationCheckSet.size()) {
            throw new IllegalArgumentException(ErrorCause.NUMBER_DUPLICATION.getMessage());
        }
    }

    // 구입금액 예외처리
    public static void throwIfPurchasePriceNotMatchToUnit(String value) {
        int purchaseAmount = Integer.parseInt(value);
        int lottoPrice = LottoConstant.PRICE.getValue();

        if (purchaseAmount % lottoPrice != 0) {
            throw new IllegalArgumentException(
                    ErrorCause.PURCHASE_PRICE_UNIT.getMessage() + "(로또 1장: " + lottoPrice + "원)"
            );
        }
    }

    // 로또 번호
    public static void throwIfNumbersAreOutOfRange(List<Integer> values) {
        for (Integer value : values) {
            if (value < LottoConstant.START_INCLUSIVE.getValue() ||
                    value > LottoConstant.END_INCLUSIVE.getValue()) {
                throw new IllegalArgumentException(ErrorCause.OUT_OF_RANGE.getMessage());
            }
        }
    }

    // 보너스 번호 예외처리
    public static void throwIfBonusNumberIsDuplicate(WinningNumber winningNumbers, String bonusNumber) {
        final HashSet<Integer> duplicationCheckSet = new HashSet<>(winningNumbers.getNumbers());
        int value = Integer.parseInt(bonusNumber);

        if (duplicationCheckSet.contains(value)) {
            throw new IllegalArgumentException(ErrorCause.NUMBER_DUPLICATION.getMessage());
        }
    }
}
