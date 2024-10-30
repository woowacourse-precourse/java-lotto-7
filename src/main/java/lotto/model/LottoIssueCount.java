package lotto.model;

public class LottoIssueCount {

    public static int calculateNumberOfLottoIssue(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / Lotto.LOTTO_PRICE;
    }
}
