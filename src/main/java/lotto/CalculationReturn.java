package lotto;

import java.util.Arrays;
import java.util.List;

public class CalculationReturn {
    LottoRank[] ranks = LottoRank.values();
    List<Integer> countRank;

    public List<Integer> getCountRank() {
        return countRank;
    }

    private void lottoRankcounter(List<Integer> lottoRank){
        countRank = Arrays.asList(0,0,0,0,0,0);
        for(int i : lottoRank){
            if(i>5){
                i=6;
            }
                countRank.set(i - 1, countRank.get(i - 1) + 1);
        }
    }

    public double calculateReturn(List<Integer> lottoRank,int amount){
        LottoRank[] ranks = LottoRank.values();
        lottoRankcounter(lottoRank);
        int index=0;
        int sumReturn=0;
        for (LottoRank rank : ranks) {
            sumReturn +=  rank.getprizeMoney()*countRank.get(index);
            index++;
        }
        double lottoReturn = (sumReturn / amount) * 100;
        return Math.round(lottoReturn * 100) / 100.0;
    }


}

