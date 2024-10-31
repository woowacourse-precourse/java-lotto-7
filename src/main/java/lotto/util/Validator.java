package lotto.util;

import lotto.exception.ValidatorException;

import java.util.List;

public class Validator {

    private static final int LOTTO_PRICE = 1000;

    // 구입 금액 검사
    public static void checkPurchasePrice(String value) {
        validatePurchasePrice(value);
    }

    private static void validatePurchasePrice(String value) {
        ValidatorException.throwIfValueIsBlank(value);
        ValidatorException.throwIfValueIsNotNumber(value);
        ValidatorException.throwIfPurchasePriceNotMatchToUnit(value, LOTTO_PRICE);
        ValidatorException.throwIfValueIsOutOfRange(value);
    }

    // 로또 검사
    public static void checkLottoTickets(List<Integer> lottoTickets) {
        validateLottoTickets(lottoTickets);
    }

    private static void validateLottoTickets(List<Integer> lottoTickets) {
        ValidatorException.throwIfValuesIsMismatch(lottoTickets);
        ValidatorException.throwIfValuesIsDuplicate(lottoTickets);
    }

    // 당첨 번호 검사
    public static void checkWinningNumbers(String[] values) {
        validateWinningNumbers(values);
    }

    private static void validateWinningNumbers(String[] values) {
        for(String value : values) {
            ValidatorException.throwIfValueIsBlank(value);
            ValidatorException.throwIfValueIsNotNumber(value);
            ValidatorException.throwIfValueIsOutOfRange(value);
        }
    }


}
