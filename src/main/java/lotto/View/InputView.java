package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.DTO.PaymentPriceDTO;
import lotto.Util.Constant.IOMessage;
import lotto.Util.Error.ErrorMessage;
import lotto.Validation.PriceValidator;

public class InputView {

    public PaymentPriceDTO inputPaymentPrice() {
        while (true) {
            System.out.println(IOMessage.INPUT_PAYMENT_PRICE.getMessage());
            String paymentPriceInput = Console.readLine();

            try {
                validatePaymentPriceType(paymentPriceInput);
                validatePaymentPriceValue(paymentPriceInput);
                return new PaymentPriceDTO(paymentPriceInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    protected void validatePaymentPriceType(String paymentPriceInput) {
        if (PriceValidator.isNotInteger(paymentPriceInput)) {
            throw new NumberFormatException(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    protected void validatePaymentPriceValue(String paymentPriceInput) {
        if (PriceValidator.isOutOfIntegerRange(paymentPriceInput)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_LIMIT_REACHED.getMessage());
        }
        if (PriceValidator.isZero(paymentPriceInput) || PriceValidator.isNegative(paymentPriceInput)) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (PriceValidator.isNotThousandUnit(paymentPriceInput)) {
            throw new ArithmeticException(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

}
