package lotto;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    LottoGameValidator lottoGameValidate = new LottoGameValidator();

    int amount;
    int lottoQuantity;

    public void inputAmount() {
        // 로또 구매액 설정
        this.amount = lottoGameValidate.readAmount(LOTTO_PRICE);
        this.lottoQuantity = amount / LOTTO_PRICE;
    }
}