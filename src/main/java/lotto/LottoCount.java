package lotto;

public class LottoCount {
    public int calculateLottoCount(int purchaseAmount) {
        int lottoQuantity = purchaseAmount / 1000;
        return lottoQuantity;
    }
}
