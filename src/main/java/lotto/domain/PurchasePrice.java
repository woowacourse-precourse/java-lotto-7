package lotto.domain;

import lotto.validation.PurchasePriceValidator;

public class PurchasePrice {

    private static final int LOTTO_PER_PRICE = 1000;

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
