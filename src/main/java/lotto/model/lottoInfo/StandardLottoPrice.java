package lotto.model.lottoInfo;

public class StandardLottoPrice extends LottoPrice {
    private static final Integer STANDARD_LOTTO_PRICE = 1000;

    @Override
    protected void initializePrice() {
        price = STANDARD_LOTTO_PRICE;
    }
}
