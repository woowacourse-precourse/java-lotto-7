package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import static lotto.Controller.bonusNum;

public class Service {
    public int BonusScore = 0;

    List<List<Integer>> generator(int sheets) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < sheets; i++) {
            lottos.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottos;
    }

    ArrayList<Integer> checkWinning(List<List<Integer>> lottos, int[] winningNum){
        ArrayList<Integer> score = new ArrayList<Integer>();
        for(List<Integer> lotto : lottos){
            int count = 0;
            for (int num: winningNum){
                if (lotto.contains(num)){
                    count+=1;
                }
                if (count == 5){
                    checkBonusNum(lotto,bonusNum);
                }
            }
            score.add(count);
        }
        return score;
    }

    void checkBonusNum(List<Integer> lotto,int bonusNum){
        int BonusScore = (lotto.contains(bonusNum)) ? 1 : 0;
    }

    int[] countWinning(ArrayList<Integer> score){
        int[] resultWinning = new int[8];
        for (int i=0;i<score.size();i++) {

            if (score.get(i) == 3) {
                resultWinning[3] += 1;
            }
            if (score.get(i) == 4) {
                resultWinning[4] += 1;
            }
            if (score.get(i) == 5) {
                if(BonusScore == 1){
                    resultWinning[6] += 1;
                }
                else{
                    resultWinning[5] += 1;
                }
            }
            if (score.get(i) == 6) {
                resultWinning[7] += 1;
            }
        }
    return resultWinning;
    }
}
