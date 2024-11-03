package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.enums.lotto.LottoMessage;

public class LottoValidator {

    private static final int PRICE_UNIT = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validatePriceUnit(int price) {
        if (price % PRICE_UNIT != 0) {
            System.out.println(LottoMessage.EXCEPTION_PRICE_UNIT.getMessage());
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_PRICE_UNIT.getMessage());
        }

        if (price <= 0) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_PRICE_UNIT.getMessage());
        }
    }

    public static int validNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println(LottoMessage.EXCEPTION_NUMBER_VALID.getMessage());
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_NUMBER_VALID.getMessage());
        }
    }

    public static void validateLottoNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                System.out.println(LottoMessage.EXCEPTION_NUMBER_RANGE.getMessage());
                throw new IllegalArgumentException(LottoMessage.EXCEPTION_NUMBER_RANGE.getMessage());
            }
        }
    }

    public static void validateDuplicateLottoNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            System.out.println(LottoMessage.EXCEPTION_DUPLICATE_LOTTO_NUMBER.getMessage());
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateDuplicateBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            System.out.println(LottoMessage.EXCEPTION_DUPLICATE_BONUS_NUMBER.getMessage());
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
