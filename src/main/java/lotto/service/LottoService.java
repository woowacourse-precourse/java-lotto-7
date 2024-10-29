package lotto.service;

import java.util.ArrayList;

import lotto.util.Rank;

public class LottoService {

    private static ArrayList<Rank> winningRecord = new ArrayList<>();

    public static int countLottoNumber(int purchaseAmount){
        return purchaseAmount/1000;
    }

    public static int countMatchNumber(int[] winningNums,ArrayList<Integer> lottoNums){
        int count=0;
        for (int winningNum : winningNums) {
            if (lottoNums.contains(winningNum)) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkBonusNumber(int bonusNumber,ArrayList<Integer> lottoNums){
        if(lottoNums.contains(bonusNumber)){
            return true;
        }
        return false;
    }

    public static double calculateProfitMargin(int totalPrize,int purchaseAmount){
        return (totalPrize/(double)purchaseAmount)*100;
    }

    public static void addWinningRecord(Rank rank){
        winningRecord.add(rank);
    }
}
