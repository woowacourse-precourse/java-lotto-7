package lotto.utils;

import lotto.error.PaymentErrorMessage;
import lotto.model.lotto.Lotto;
import lotto.constants.LottoNumber;

import java.math.BigInteger;

public class PaymentValidator {

    static final int MIN_PAYMENT = 0;
    static final int INTEGER_PART = 0;
    static final int DECIMAL_PART = 1;
    static final int MAX_SPLIT_PAYMENT_LENGTH = 2;
    static final String DOT = "\\.";
    static final double ALLOW_LOTTO_OBJECT_SIZE_RATE = 0.7;

    public boolean validate(String paymentInput) {
        String[] splitPayment = paymentInput.split(DOT);
        String integerPart = splitPayment[INTEGER_PART];

        validateFormat(splitPayment, integerPart);
        validateMaxValue(integerPart);
        validateNumber(integerPart);

        return true;
    }

    private void validateFormat(String[] splitPayment, String integerPart) {
        if (splitPayment.length > MAX_SPLIT_PAYMENT_LENGTH) {
            throw new IllegalArgumentException(PaymentErrorMessage.WRONG_PAYMENT_FORMAT.getMessage());
        }

        if (hasDecimal(splitPayment)) {
            String decimalPart = splitPayment[DECIMAL_PART];
            validateHasOnlyZero(decimalPart);
        }

        if (!integerPart.matches(LottoNumber.FORMAT)) {
            throw new IllegalArgumentException(PaymentErrorMessage.WRONG_PAYMENT_FORMAT.getMessage());
        }
    }

    private void validateMaxValue(String integerPart) {
        BigInteger freeMemory = calcFreeMemory();
        BigInteger totalLottoObjectSize = calcTotalLottoObjectSize(integerPart);

        if (freeMemory.compareTo(totalLottoObjectSize) < 0) {
            throw new IllegalArgumentException(PaymentErrorMessage.EXCEED_MAX_PAYMENT.getMessage());
        }
    }

    private BigInteger calcFreeMemory() {
        Runtime runtime = Runtime.getRuntime();
        return BigInteger.valueOf((long) (runtime.freeMemory() * ALLOW_LOTTO_OBJECT_SIZE_RATE));
    }

    private BigInteger calcTotalLottoObjectSize(String integerPart) {
        return new BigInteger(integerPart).multiply(BigInteger.valueOf(Lotto.LOTTO_OBJECT_SIZE));
    }

    private void validateNumber(String integerPart) {
        long payment = Long.parseLong(integerPart);

        if (payment < MIN_PAYMENT) {
            throw new IllegalArgumentException(PaymentErrorMessage.NEGATIVE_PAYMENT.getMessage());
        }

        if (payment % Lotto.PRICE > 0) {
            throw new IllegalArgumentException(PaymentErrorMessage.NOT_MULTIPLE_OF_THOUSAND_PAYMENT.getMessage());
        }
    }

    private void validateHasOnlyZero(String decimalPart) {
        if (!hasOnlyZero(decimalPart)) {
            throw new IllegalArgumentException(PaymentErrorMessage.WRONG_PAYMENT_FORMAT.getMessage());
        }
    }

    private boolean hasDecimal(String[] splitPayment) {
        return splitPayment.length == MAX_SPLIT_PAYMENT_LENGTH;
    }

    private boolean hasOnlyZero(String decimalPart) {
        return countZero(decimalPart) == decimalPart.length();
    }

    private long countZero(String decimalPart) {
        return decimalPart.chars().filter(ch -> ch == '0').count();
    }
}
