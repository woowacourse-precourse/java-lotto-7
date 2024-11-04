package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class LottoResult {
    HashMap<Integer, Integer> result = new HashMap<>();
    List<Lotto> lottos;
    List<Integer> inputNumber;
    int bonusNumber;
    StringBuilder sb = new StringBuilder();
    public LottoResult(List<Lotto> lottos,List<Integer> inputNumber,int bonusNumber) {
        this.lottos = lottos;
        this.inputNumber = inputNumber;
        this.bonusNumber = bonusNumber;
    }
    public LottoResult() {
    }
    public void defaultSettingResult(){
        for(int i=3;i<=7;i++){
            result.put(i, 0);
        }
    }
    public void recordResult() {
        defaultSettingResult();
        for (Lotto lotto : lottos) {
            int count = countCollectNumber(lotto);
            boolean bonusMatch = checkHitBonus(lotto,bonusNumber);
            if (count == 5 && bonusMatch) {
                result.put(6, result.getOrDefault(6, 0) + 1);
            }
            if (count == 6) {
                result.put(7, result.getOrDefault(7, 0) + 1);
            }
            if (count >= 3 && !(count == 5 && bonusMatch)) {
                result.put(count, result.getOrDefault(count, 0) + 1);
            }
        }
    }

    public int countCollectNumber(Lotto lotto){
        int count = 0;
        List<Integer> numbers = lotto.getNumbers();
        for (Integer value : inputNumber) {
            if (numbers.contains(value)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkHitBonus(Lotto lotto,int bonusNumber){
        return lotto.getNumbers().contains(bonusNumber);
    }

    public void getResult() {
        long sum = 0L;
        for (Entry<Integer, Integer> i : result.entrySet()) {
            LottoRank rank = LottoRank.findRankFromKey(i.getKey());
            sb.append(rank.getDescription()).append(i.getValue()).append("개").append("\n");
            sum += rank.getPrize() *i.getValue();
        }
        sb.append("총 수익률은 ").append(calculateEarnings(sum,lottos.size())).append("%입니다.");
        System.out.println(sb);
    }


    public double calculateEarnings(long sum,int lottosSize) {
        double earnings = (double) sum / (lottosSize* 1000)*100;
        return Math.round(earnings * 10.0) / 10.0;

    }

}

