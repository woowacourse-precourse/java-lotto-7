package lotto.dto;

import java.util.HashMap;
import lotto.utils.LottoMatchStatus;

public class LottoResultDto {
    private HashMap<LottoMatchStatus, Integer> lottoResult;
    private double profit;
    public LottoResultDto(HashMap<LottoMatchStatus, Integer> lottoResult, double profit){
        this.lottoResult = lottoResult;
        this.profit = profit;
    }

    public HashMap<LottoMatchStatus, Integer> getLottoResult(){
        return lottoResult;
    }

    public double getProfit(){
        return profit;
    }
}
