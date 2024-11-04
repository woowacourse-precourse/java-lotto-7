package lotto.utils;

import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.exception.LottoExceptionStatus.*;
import static lotto.exception.LottoExceptionStatus.INVALID_BONUS_NUMBER_FORMAT;

public class LottoUtils {

    public static int countEqualLottoNumbers(Lotto myLotto,
                                             List<Integer> winningLotto) {

        return (int) myLotto.getNumbers()
                .stream()
                .filter(winningLotto::contains)
                .count();
    }

    public static boolean checkContainsBonusNumber(Lotto myLotto,
                                                   int bonusNumber) {
        return myLotto.getNumbers()
                .contains(bonusNumber);
    }

    public static int checkPurchaseNumberFormat(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_NUMBER_FORMAT.getMessage());
        }
    }

    public static List<Integer> checkLottoNumberFormat(String winningLotto) {
        try {
            return Arrays.stream(winningLotto.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    public static int checkBonusNumberFormat(String bonusNumber){
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT.getMessage());
        }
    }
}
