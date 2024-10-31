package lotto.service;

import lotto.error.CustomException;
import lotto.error.ExceptionMessage;

public class InputService {
    private final String NUMBER_REGEX = "^(-[1-9][0-9]*|[1-9][0-9]*|0)$";
    private final int LOTTO_PRICE = 1000;

    public boolean isNumber(String number) {
        return number.matches(NUMBER_REGEX);
    }

    public boolean isPositiveNumber(int number) {
        return (number > 0);
    }

    public boolean isValidCost(int cost) {
        return (cost % LOTTO_PRICE == 0);
    }

    public int validateLottoCost(String lottoCost) {
        if (!isNumber(lottoCost)) {
            throw new CustomException(ExceptionMessage.ERROR_MESSAGE_IS_NOT_NUMBER);
        }
        int cost = Integer.parseInt(lottoCost);
        if (!isPositiveNumber(cost)) {
            throw new CustomException(ExceptionMessage.ERROR_MESSAGE_IS_NOT_POSITIVE_NUMBER);
        }
        if (!isValidCost(cost)) {
            throw new CustomException(ExceptionMessage.ERROR_MESSAGE_IS_NOT_VALID_COST);
        }
        return cost;
    }

    public int calculateLottoCount(int cost) {
        return cost / LOTTO_PRICE;
    }
}
