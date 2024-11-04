package lotto.controller;
import lotto.exceptions.LottoNumberRangeException;
import lotto.exceptions.LottoPriceUnder1000Exception;
import lotto.exceptions.LottoPriceUnitException;

public class LottoValidator {
    public static void isValidAmount(int purchaseAmount) {
        if (!isAboveMinimumPrice(purchaseAmount)) {
            throw new LottoPriceUnder1000Exception();
        }
        if (!isMultipleOfThousand(purchaseAmount)) {
            throw new LottoPriceUnitException();
        }
    }

    public static void isValidBonusNumber(int bonusNumber) {
        if (!isWithinBonusNumberRange(bonusNumber)) {
            throw new LottoNumberRangeException();
        }
    }

    private static boolean isAboveMinimumPrice(int amount) {
        return amount >= 1000;
    }

    private static boolean isMultipleOfThousand(int amount) {
        return amount % 1000 == 0;
    }

    private static boolean isWithinBonusNumberRange(int number) {
        return number >= 1 && number <= 45;
    }
}
