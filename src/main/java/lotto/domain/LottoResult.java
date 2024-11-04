package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> prizeResult;

    public LottoResult(Map<Rank, Integer> prizeResult){
        this.prizeResult=prizeResult;
    }

    public Map<Rank, Integer> getPrizeResult() {
        return prizeResult;
    }

    public double calculateInvestment(PaymentInput paymentInput){
        long totalPrize=0;

        for (Rank rank:prizeResult.keySet()){
            totalPrize+=prizeResult.get(rank)*rank.getPrizeAmount();
        }

        double gain = totalPrize / (double) paymentInput.getPayment() * 100;

        return Math.round(gain * 10) / 10.0;
    }
}
