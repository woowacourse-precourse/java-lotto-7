package validator;

import java.util.Collections;
import java.util.List;
import message.ErrorMessage;
import model.Lotto;

public class Validator {
    public static void lottoShouldBeBetweenOneAndFortyFive(List<Integer> lotto) {
        for (Integer lottoNumber : lotto) {
            shouldBeBetweenOneAndFortyFive(lottoNumber);
        }
    }

    public static void shouldBeBetweenOneAndFortyFive(Integer lottoNumber) {
        if (!(1 <= lottoNumber && lottoNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getErrorMessage());
        }
    }

    public static void lottoShouldNotOverlap(List<Integer> lotto) {
        for (Integer lottoNumber : lotto) {
            if (Collections.frequency(lotto, lottoNumber) > 1) {
                throw new IllegalArgumentException(
                        ErrorMessage.LOTTO_NUMBER_OVERLAP.getErrorMessage());
            }
        }
    }

    public static void shouldNotOverlap(Lotto lotto, String bonusNumber) {
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (lottoNumber.equals(Integer.parseInt(bonusNumber))) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OVERLAP.getErrorMessage());
            }
        }
    }

    public static void lottoNumbersShouldBeSix(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIX.getErrorMessage());
        }
    }

    public static void lottoShouldBeSortedInAscendingOrder(List<Integer> lotto) {
        Integer value = 0;
        for (Integer lottoNumber : lotto) {
            if (lottoNumber <= value) {
                throw new IllegalArgumentException(
                        ErrorMessage.LOTTO_NUMBER_ASCENDING.getErrorMessage());
            }
            value = lottoNumber;
        }
    }

    public static void shouldBeOnlyNumber(String money) {
        for (int i = 0; i < money.length(); i++) {
            char number = money.charAt(i);
            if (!util.Validator.isNumber(number)) {
                throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getErrorMessage());
            }
        }
    }


    public static void shouldNotBeEmpty(String money) {
        if (money.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_EMPTY.getErrorMessage());
        }
    }

    public static void shouldNotBeDividedBy1000(String money) {
        if (money.length() < 3) {
            throw new IllegalArgumentException(
                    ErrorMessage.IS_NOT_MULTIPLE_OF_ONE_THOUSAND.getErrorMessage());
        }

        String checkPoint = money.substring(money.length() - 3);

        if (!checkPoint.equals("000")) {
            throw new IllegalArgumentException(
                    ErrorMessage.IS_NOT_MULTIPLE_OF_ONE_THOUSAND.getErrorMessage());
        }
    }

    public static void shouldNotBeTooBig(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_TOO_LARGE.getErrorMessage());
        }
    }

}
