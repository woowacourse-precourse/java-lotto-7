package lotto;

public class PaymentValidator {

    static final long MAX_PAYMENT = 8145060000L;
    static final int MIN_PAYMENT = 0;
    static final int INTEGER_INDEX = 0;
    static final int DECIMAL_INDEX = 1;
    static final int MAX_SPLIT_PAYMENT_LENGTH = 2;
    static final int PAYMENT_UNIT = 1000;
    static final String INTEGER_FORMAT = "-?\\d+";
    static final String DELIMITER = "\\.";

    public boolean validate(String paymentInput) {
        String[] splitPayment = paymentInput.split(DELIMITER);
        String integerPart = splitPayment[INTEGER_INDEX];

        validateFormat(splitPayment, integerPart);
        validateNumber(integerPart);

        return true;
    }

    private void validateFormat(String[] splitPayment, String integerPart) {
        if (splitPayment.length > MAX_SPLIT_PAYMENT_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PAYMENT_FORMAT.getMessage());
        }

        if (hasDecimal(splitPayment)) {
            String decimalPart = splitPayment[DECIMAL_INDEX];
            validateHasOnlyZero(decimalPart);
        }

        if (!integerPart.matches(INTEGER_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PAYMENT_FORMAT.getMessage());
        }
    }

    private void validateHasOnlyZero(String decimalPart) {
        if (!hasOnlyZero(decimalPart)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PAYMENT_FORMAT.getMessage());
        }
    }

    private void validateNumber(String integerPart) {
        long payment = Long.parseLong(integerPart);

        if (payment < MIN_PAYMENT) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PAYMENT.getMessage());
        }

        if (payment % PAYMENT_UNIT > 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND_PAYMENT.getMessage());
        }

        if (MAX_PAYMENT < payment) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_MAX_PAYMENT.getMessage());
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
