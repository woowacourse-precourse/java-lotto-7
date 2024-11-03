package lotto.exception;


import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Validator {
    public static final int LOTTERY_NUMBERS_SIZE = 6;
    public static final long LOTTERY_PRICE = 1000;
    public static final int MINIMUM_LOTTERY_NUMBER = 1;
    public static final int MAXIMUM_LOTTERY_NUMBER = 45;
    public static final int MINIMUM_PAYMENT = 0;
    private static long lotteryNumber;

    public static long inputValid(String input) {
        try {
            long inputNumber = isNumeric(input);
            isMoreThanMinimum(inputNumber, MINIMUM_PAYMENT);
            lotteryNumber = isDividedByDivisor(LOTTERY_PRICE, inputNumber);
        } catch (IllegalArgumentException e) {
            OutputView.getInstance().printErrorMessage(e.getMessage());
            InputView.getInstance().enterPaymentForLottery();
        }
        return lotteryNumber;
    }

    public static List<Integer> isNumeric(List<String> inputElements) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (String element : inputElements) {
            try {
                inputNumbers.add(isNumeric(element));
            } catch (IllegalArgumentException e) {
                OutputView.getInstance().printErrorMessage(e.getMessage());
                throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMERIC);
            }
        }
        return inputNumbers;
    }

    public static int isNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMERIC);
        }
    }

    public static void isMoreThanMinimum(long payment, int minimumPayment) {
        if (payment <= minimumPayment) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT);
        }
    }

    public static long isDividedByDivisor(long lotteryPrice, long payment) {
        if (payment % lotteryPrice != 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIVIDED_BY_LOTTERY_NUMBER);
        }

        return payment / lotteryPrice;
    }

    public static void isRightSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTERY_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.IS_INVALID_SIZE);
        }
    }

    public static void isRightRange(List<Integer> lottoNumbers) {
        for (long number : lottoNumbers) {
            if (number < MINIMUM_LOTTERY_NUMBER || number > MAXIMUM_LOTTERY_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.IS_INVALID_RANGE);
            }
        }
    }

    public static void isRightRange(int lottoNumber) {
        if (lottoNumber < MINIMUM_LOTTERY_NUMBER || lottoNumber > MAXIMUM_LOTTERY_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.IS_INVALID_RANGE);
        }
    }

    public static void isDuplicated(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.IS_DUPLICATED);
        }
    }
}
