package lotto.domain;

public class Payment {

    private static final int LOTTO_PRICE = 1000;

    private final int lottoCount;

    private Payment(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static Payment of(int money){
        return new Payment(calculateLottoCount(money));
    }

    public int getLottoCount(){
        return this.lottoCount;
    }


    private static int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
