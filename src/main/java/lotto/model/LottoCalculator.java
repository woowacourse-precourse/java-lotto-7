package lotto.model;

import static lotto.Constants.LOTTO_PRICE;

import java.util.Map;
import lotto.Rank;

public class LottoCalculator {

    private int payment;
    private Map<Rank, Integer> lottoResult;

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setLottoResult(Map<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public int getLottoAmount() {
        return payment / LOTTO_PRICE;
    }

    public float getEarningRateFrom() {
        int totalEarning = getTotalEarning();
        return (float) totalEarning / payment * 100;
    }

    private int getTotalEarning() {
        return lottoResult.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
            .sum();
    }
}
