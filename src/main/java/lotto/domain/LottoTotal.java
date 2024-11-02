package lotto.domain;

import java.util.List;

public class LottoTotal {
    public LottoTotal(){
    }
    public int[] winningLotto(List<Integer> randomLottoNumber,List<Integer> winsNumber) {
        int batchSize = 6;
        int[] count=new int[7];
        for (int i = 0; i <= randomLottoNumber.size() - batchSize; i += batchSize) {
            List<Integer> currentLottoSet = randomLottoNumber.subList(i, i + batchSize);
            int matchCount = countMatches(currentLottoSet, winsNumber);
            updateCount(count, matchCount);
        }
        return count;
    }
    private int countMatches(List<Integer> currentLottoSet, List<Integer> winsNumber) {
        int matchCount = 0;
        for (Integer number : currentLottoSet) {
            if (winsNumber.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private void updateCount(int[] count, int matchCount) {
        if (matchCount > 2) {
            count[matchCount]++;
        }
    }
    public int bonusMatches(int bonusNum,List<Integer> winsNumber){
        int correct=0;
        for (Integer number : winsNumber) {
            if (winsNumber.contains(number)) {
                correct++;
            }
        }
        return correct;
    }
}
