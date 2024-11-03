package lotto.service;

import lotto.validator.LottoValidator;

public class LottoTicketBuyingService {
    public static Integer buyingLottoTicket(String buyingPrice) {
        LottoValidator.validatePurchaseAmountFormat(buyingPrice);
        int price = Integer.parseInt(buyingPrice);
        LottoValidator.validatePurchaseAmount(price);
        return price / 1000;
    }
}
