package lotto.service;

public class LottoService {
    private static Integer DIVIDED_AMOUNT = 1000;

    public int getPurchaseCount(int purchaseAmount) {
        return purchaseAmount / DIVIDED_AMOUNT;
    }
}
