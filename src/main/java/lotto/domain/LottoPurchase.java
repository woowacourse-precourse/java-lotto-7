package lotto.domain;

public class LottoPurchase {
    private final LottoPrice lottoPrice;
    private final LottoCount lottoCount;

    public LottoPurchase(int gameMoney) {
        this.lottoPrice = new LottoPrice(gameMoney);
        this.lottoCount = new LottoCount(lottoPrice);
    }

    public LottoCount getLottoCount() {
        return lottoCount;
    }

    public String calculateEarnRate(int prizeMoney) {
        double rate = (double) prizeMoney / lottoPrice.getgameMoney();
        return String.format("%.1f", rate * 100);
    }
}
