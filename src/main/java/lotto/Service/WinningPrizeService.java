package lotto.Service;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningPrizeService {
    private List<Integer> winningPrizes= new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0));
    private int five_bonus=0;

    public List<Integer> getWinningPrizes() {
        return winningPrizes;
    }

    public int getFive_bonus() {
        return five_bonus;
    }


    public void matchAllLotos(List<Lotto>lottos,Lotto winningLoto,Integer bonusNumber){
        for (Lotto lotto : lottos) {
            checkEachLoto(lotto.getNumbers(),winningLoto.getNumbers(),bonusNumber);
        }
    }


    private void checkEachLoto(List<Integer>lotto, List<Integer> winningLotoNumbers, Integer bonusNumber){
        int matchCount=0;
        boolean bonusNumberMatching=false;
        for (Integer userNumber : lotto) {
            if (checkEachNumber(userNumber, winningLotoNumbers)){
                matchCount+=1;
            }
            if (checkBonusNumber(userNumber,bonusNumber)){
                bonusNumberMatching=true;
            }
        }
        reflectPrize(matchCount,bonusNumberMatching);
    }

    private boolean checkEachNumber(int userNumber,List<Integer>winningLotoNubers){
        for (Integer winningLotoNuber : winningLotoNubers) {
            if (winningLotoNuber==userNumber){
                return true;
            }
        }
        return false;
    }

    private boolean checkBonusNumber(int userNumber , int bonusNumber){
        return userNumber==bonusNumber;
    }

    private void reflectPrize(int matchCount, boolean bonusNumberMatching){
        if (matchCount != 5){
            winningPrizes.set(matchCount, winningPrizes.get(matchCount)+1);
            return;
        }
        if (bonusNumberMatching){
            five_bonus+=1;
            return;
        }
        winningPrizes.set(matchCount, winningPrizes.get(matchCount)+1);
    }




}
