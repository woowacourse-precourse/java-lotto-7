package lotto.domain;

import lotto.util.ParserToInt;
import lotto.validation.AmountValidator;

import static lotto.constant.Constant.LOTTO_PRICE;

public class PurchaseAmount {

    private final int lottoTickets;

    /**
     * 구입 금액을 정수형으로 변환하고 적합한 금액인지 검증
     * @param strAmount 구입 금액(문자열)
     * @return
     */
    public PurchaseAmount(String strAmount){
        this.lottoTickets = validateAmount(ParserToInt.parserToInt(strAmount)) / LOTTO_PRICE;
    }

    public int getLottoTickets(){
        return lottoTickets;
    }

    private int validateAmount(int amount){
        AmountValidator.isPositive(amount);
        AmountValidator.isDivisibleByThousand(amount);
        return amount;
    }
}
