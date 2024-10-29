package lotto.application;

import lotto.domain.PrizeNumber;

public interface Calculator {

    int calculateTotalPrize(PrizeNumber prizeNumber);

    double calculateProfit(int totalPrize,int purchasePrice);
}
