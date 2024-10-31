package lotto.domain;

import java.util.Map;

public class PrizeResult {
    Map<Rank,Integer> prizeResult;
    PaymentInput paymentInput;

    public PrizeResult(Map<Rank,Integer> prizeResult,PaymentInput paymentInput){
        this.prizeResult=prizeResult;
        this.paymentInput=paymentInput;
    }

    public double calculateInvestment(){
        long totalPrize=0;

        for (Rank rank:prizeResult.keySet()){
            totalPrize+=(prizeResult.get(rank)*(rank.getPrizeAmount()));
        }
        return Math.round(totalPrize/paymentInput.getPayment());
    }
}
