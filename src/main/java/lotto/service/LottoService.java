package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;

import lotto.util.Rank;

public class LottoService {

    private HashMap<Integer,Integer> winningRecord = new HashMap<>();

    public LottoService() {
        for (int i = Rank.FIRST.getRankOrder(); i <= Rank.FIFTH.getRankOrder(); i++) {
            winningRecord.put(i, 0);
        }
    }

    public int countLotto(int purchaseAmount){
        return purchaseAmount/1000;
    }

    public int countMatchNumber(int[] winningNums,ArrayList<Integer> lottoNums){
        int count=0;
        for (int winningNum : winningNums) {
            if (lottoNums.contains(winningNum)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBonusNumber(int bonusNumber,ArrayList<Integer> lottoNums){
        if(lottoNums.contains(bonusNumber)){
            return true;
        }
        return false;
    }

    public double calculateProfitMargin(int totalPrize,int purchaseAmount){
        return (totalPrize/(double)purchaseAmount)*100;
    }

    public void addWinningRecord(Rank rank){
        int rankOrder = rank.getRankOrder();
        winningRecord.put(rankOrder, winningRecord.get(rankOrder)+1);
    }

    public HashMap<Integer,Integer> getWinningRecord(){
        return winningRecord;
    }
}
