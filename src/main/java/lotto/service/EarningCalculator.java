package lotto.service;

import lotto.LottoConstants;

import java.util.List;

public class EarningCalculator {
    public double calcualteEarningRate(List<Integer> winners, Integer cash) {
        double priceMoney = 0L;
        for(Integer winner : winners) {
            priceMoney += earingMoney(winner);
        }
        return ((double) priceMoney / cash) * 100;
    }
    private int earingMoney(Integer winners) {
        if(winners == 3) {
            return LottoConstants.THREE_LOTTO_PRICE;
        }
        if(winners == 4) {
            return LottoConstants.FOUR_LOTTO_PRICE;
        }
        if(winners == 5) {
            return LottoConstants.FIVE_LOTTO_PRICE;
        }
        if(winners == 6) {
            return LottoConstants.SIX_LOTTO_PRICE;
        }
        if(winners == 7) {
            return LottoConstants.FIVE_AND_BONUS_LOTTO_PRICE;
        }
    }
}
