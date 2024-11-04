package lotto;

import validator.PaymentValidator;

public class TicketVendor {
    public static int vendor(Integer money) {
        PaymentValidator.validate(money);
        return money / AbsoluteValue.TICKET_PRICE;
    }
}
