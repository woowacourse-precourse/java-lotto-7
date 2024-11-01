package lotto.domain;

import lotto.validation.PurchasePriceValidator;

public class PurchasePrice {
    //구매금액이 유효한지 확인하는 클래스
    private static final int LOTTO_PER_PRICE = 1000;

    private final int amount;

    public PurchasePrice(String price){
        PurchasePriceValidator.validator(price);
        this.amount = Integer.parseInt(price);
    }

    public int getLottoTicketCount(){
        return amount / LOTTO_PER_PRICE;
    }
}
