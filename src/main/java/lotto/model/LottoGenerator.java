package lotto.model;

public class LottoGenerator {
    static final int PRICE = 1000;

    public int purchasableLottoCount(int paymentAmount) {
        if(paymentAmount % PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 "+ PRICE +" 단위로 입력해야 합니다.");
        }
        return paymentAmount/PRICE;
    }
}
