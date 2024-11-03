package lotto.service;

import lotto.domain.BuyingPrice;
import lotto.util.BuyingPriceParser;
import static lotto.util.BuyingPriceParser.toIntStringPriceParser;

public class BuyingPriceService {
    public static int returnNumberOfLotto(BuyingPrice buyingPrice){
        int lottoNum = 0;
        int price = buyingPrice.getPrice();
        try {
            lottoNum = price / 1000;
        }catch(ArithmeticException e) {
            System.out.println("연산에서의 오류 발생");
        }
        return lottoNum;
    }
}
