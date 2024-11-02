package lotto.domain;

import java.util.Map;

public class TotalGain {
    Map<Rank,Integer> prizeResult;
    PaymentInput paymentInput;

    public TotalGain(Map<Rank,Integer> prizeResult, PaymentInput paymentInput){
        this.prizeResult=prizeResult;
        this.paymentInput=paymentInput;
    }

    public Map<Rank, Integer> getPrizeResult() {
        return prizeResult;
    }

    public PaymentInput getPaymentInput() {
        return paymentInput;
    }


    public double calculateInvestment(){
        long totalPrize=0;

        for (Rank rank:prizeResult.keySet()){
            totalPrize+=(prizeResult.get(rank)*(rank.getPrizeAmount()));
        }
        double gain=totalPrize/(double)paymentInput.getPayment()*100;

        return Math.round(gain*10)/10.0;
    }
}
