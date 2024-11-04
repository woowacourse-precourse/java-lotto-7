package lotto.service;

import lotto.domain.lotto.Rank;
import lotto.domain.purchase.PurchaseAmount;

import java.util.List;

public class ProfitCalculatorService {

    public double calculateProfitRate(List<Rank> ranks, PurchaseAmount purchaseAmount) {
        int totalPrize = 0;

        for (Rank rank : ranks) {
            totalPrize += rank.getPrizeMoney();
        }

        return ((double) totalPrize / purchaseAmount.getPurchaseAmount()) * 100;
    }
}
