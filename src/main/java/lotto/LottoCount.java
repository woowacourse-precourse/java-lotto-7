package lotto;

public class LottoCount {
    public int calculateLottoCount(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        return numberOfLottos;
    }
}
