package lotto.service;

import java.util.ArrayList;

import lotto.util.Rank;

public class LottoService {

    private ArrayList<Rank> winningRecord = new ArrayList<>();

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
        winningRecord.add(rank);
    }

    public ArrayList<Rank> getWinningRecord(){
        return winningRecord;
    }
}
