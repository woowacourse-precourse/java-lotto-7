package lotto.service;

import java.util.ArrayList;
import java.util.List;
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

    public boolean isLottoRange(int number) {
        return number >= 1 && number <= 45;
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

    public int validateWinningNumber(String element) {
        if (!isNumber(element)) {
            throw new CustomException(ExceptionMessage.ERROR_MESSAGE_IS_NOT_NUMBER);
        }
        int number = Integer.parseInt(element);
        if (!isLottoRange(number)) {
            throw new CustomException(ExceptionMessage.ERROR_MESSAGE_IS_NOT_IN_LOTTO_NUMBER_RANGE);
        }
        return number;
    }

    public List<Integer> extractWinningNumbers(String winningNumber) {
        String[] parsedElements = winningNumber.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String element : parsedElements) {
            int number = validateWinningNumber(element);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    public int validateBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        int number = validateWinningNumber(bonusNumber);
        for (Integer winningNumber : winningNumbers) {
            if (number == winningNumber) {
                throw new CustomException(ExceptionMessage.ERROR_MESSAGE_DUPLICATED_LOTTO_NUMBER);
            }
        }
        return number;
    }

}
