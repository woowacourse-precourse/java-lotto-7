package lotto.service;

import java.util.HashMap;
import java.util.List;

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

    public int countMatchNumber(int[] winningNums,List<Integer> lottoNums){
        int count=0;
        for (int winningNum : winningNums) {
            if (lottoNums.contains(winningNum)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBonusNumber(int bonusNumber,List<Integer> lottoNums){
        if(lottoNums.contains(bonusNumber)){
            return true;
        }
        return false;
    }

    public double calculateProfitMargin(HashMap<Integer,Integer> winningRecord,int purchaseAmount){
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue; 
            }
    
            int count = winningRecord.getOrDefault(rank.getRankOrder(), 0);
            totalPrize += rank.getPrize() * count; 
        }
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
