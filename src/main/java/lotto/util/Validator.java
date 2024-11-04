package lotto.util;

import java.util.List;
import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class Validator {

    public static void validateMoney(String input) {
        try {
            int num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorCode.INVALID_MONEY_TYPE);
        }
    }

    public static void validateLottoNums(List<String> input) {
        for (String number : input) {
            try {
                int num = Integer.parseInt(number); // 정수로 변환을 시도
            } catch (NumberFormatException e) {
                throw new CustomException(ErrorCode.INVALID_LOTTO_TYPE);
            }
        }
    }

    public static void validateBonus(String input) {
        try {
            int num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CustomException(ErrorCode.INVALID_BONUS_TYPE);
        }
    }


}
