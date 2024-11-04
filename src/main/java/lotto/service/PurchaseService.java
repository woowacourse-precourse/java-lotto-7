package lotto.service;

import java.util.List;
import lotto.domain.Purchase;
import lotto.domain.WinningResult;

public class PurchaseService {
    private int price;

    public int buyLotto(int price) {
        this.price = price;
        Purchase purchase = new Purchase(price);
        return purchase.calculatePurchasableLotto();
    }

    public double calculateWinningPercent(List<WinningResult> results) {
        int totalPrize = calculateTotalPrize(results);
        int investment = price;
        return ((double)totalPrize - investment) / investment * 100;
    }

    private int calculateTotalPrize(List<WinningResult> results) {
        int totalPrize = 0;
        for(WinningResult result : results) {
            totalPrize += result.getPrize();
        };
        return totalPrize;
    }

}
