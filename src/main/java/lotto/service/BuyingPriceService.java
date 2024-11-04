package lotto.service;

import lotto.domain.BuyingPrice;

public class BuyingPriceService {
    public int returnNumberOfLotto(BuyingPrice buyingPrice){
        int lottoNum = 0;
        int price = buyingPrice.getPrice();
        lottoNum = price / 1000;

        return lottoNum;
    }
}
