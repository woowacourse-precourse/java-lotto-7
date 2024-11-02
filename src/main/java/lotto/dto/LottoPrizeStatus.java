package lotto.dto;

import java.util.HashMap;
import lotto.model.LottoPrize;

public class LottoPrizeStatus {

    private HashMap<LottoPrize, Integer> prizeStatus;
    private double returnOnInvestment;

    public LottoPrizeStatus(HashMap<LottoPrize, Integer> prizeStatus, double returnOnInvestment) {
        this.prizeStatus = prizeStatus;
        this.returnOnInvestment = returnOnInvestment;
    }

    public HashMap<LottoPrize, Integer> getPrizeStatus() {
        return prizeStatus;
    }

    public double getReturnOnInvestment() {
        return returnOnInvestment;
    }
}
