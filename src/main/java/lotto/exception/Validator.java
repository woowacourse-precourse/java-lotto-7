package lotto.exception;

import lotto.view.InputView;

public class Validator {
    public static final long LOTTERY_PRICE = 1000;
    public static final int MINIMUM_PAYMENT = 0;

    public static long inputValid(String input) {
        long lotteryNumber;
        while (true) {
            try {
                long inputNumber = isNumeric(input);
                isMoreThanMinimum(inputNumber, MINIMUM_PAYMENT);
                lotteryNumber = isDividedByDivisor(LOTTERY_PRICE, inputNumber);
                break;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                InputView.getInstance().enterPaymentForLottery();
            }
        }
        return lotteryNumber;
    }

    public static long isNumeric(String input) {
        try {
            return Long.parseLong(input);
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
}
