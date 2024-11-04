package lotto.service;

import lotto.domain.LottoTicket;

public class Calculating {
    private static final int PERCENTAGE = 100;
    public double earningRate(LottoTicket ticket){
        double earning = ( ticket.getProfitSum() /(double)ticket.getPrice())*PERCENTAGE;
        return Math.round(earning*10)/10.0;
    }

}
