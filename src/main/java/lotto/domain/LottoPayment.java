package lotto.domain;

import static lotto.constant.ExceptionMessage.INSUFFICIENT_BALANCE;
import static lotto.constant.ExceptionMessage.INVALID_PAYMENT_AMOUNT;
import static lotto.constant.LottoConstants.SINGLE_TICKET_PRICE;

import lotto.vo.Money;

public class LottoPayment {
    private final Money initialAmount;
    private Money remainingAmount;

    private LottoPayment(Money amount) {
        validatePurchaseWithoutChange(amount);

        this.initialAmount = amount;
        this.remainingAmount = amount;
    }

    public static LottoPayment from(Money amount) {
        return new LottoPayment(amount);
    }

    private void validatePurchaseWithoutChange(Money amount) {
        if (!amount.isDivisibleBy(SINGLE_TICKET_PRICE)) {
            throw new IllegalArgumentException(INVALID_PAYMENT_AMOUNT.format(SINGLE_TICKET_PRICE));
        }
    }

    public void deductSingleTicket() {
        if (!hasSufficientAmount()) {
            throw new IllegalArgumentException(INSUFFICIENT_BALANCE.message());
        }

        this.remainingAmount = remainingAmount.subtract(SINGLE_TICKET_PRICE);
    }

    public boolean hasSufficientAmount() {
        return remainingAmount.isGreaterThanOrEqual(SINGLE_TICKET_PRICE);
    }

    public Money getInitialAmount() {
        return initialAmount;
    }
}
