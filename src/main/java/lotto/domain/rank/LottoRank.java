package lotto.domain.rank;

public class LottoRank {

    private final int lottoCount;
    private final int price;

    public LottoRank(int lottoCount, boolean isBonus) {
        this.lottoCount = lottoCount;
        this.price = calculatePrice(lottoCount, isBonus);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getPrice() {
        return price;
    }

    private int calculatePrice(int lottoCount, boolean isBonus) {
        return LottoPrice.getByLottoCount(lottoCount, isBonus);
    }
}
