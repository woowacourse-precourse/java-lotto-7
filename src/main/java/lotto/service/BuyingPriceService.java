package lotto.service;

import lotto.domain.BuyingPrice;
import lotto.util.BuyingPriceParser;
import static lotto.util.BuyingPriceParser.toIntStringPriceParser;

public class BuyingPriceService {
    public static int returnNumberOfLotto(BuyingPrice buyingPrice){
        int lottoNum = 0;
        int price = buyingPrice.getPrice();
        lottoNum = price / 1000;

        return lottoNum;
    }
}
