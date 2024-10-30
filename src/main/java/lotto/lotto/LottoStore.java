package lotto.lotto;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private int lottoNumberOfPurchases;



    public void calculateNumberOfPurchases(int money) {
        if (money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("잘못된 입력 값 입니다. 확인 바랍니다.");
        }
        lottoNumberOfPurchases = money % LOTTO_PRICE;
    }
}
