package lotto.domain;

import static lotto.constants.LottoConstant.LOTTO_PER_PRICE;

import lotto.validation.PurchasePriceValidator;

public class PurchasePrice {

    private final int amount;

    public PurchasePrice(String price){
        PurchasePriceValidator.validator(price);
        this.amount = Integer.parseInt(price);
    }

    public int getLottoTicketCount(){
        return amount / LOTTO_PER_PRICE;
    }

    public int getAmount(){
        return amount;
    }
}
