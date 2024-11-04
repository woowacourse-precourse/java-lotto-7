package lotto.domain;

import java.util.List;

public class LottoTotal {
    public LottoTotal(){
    }
    public static int[] winningLotto(List<Integer> randomLottoNumber,List<Integer> winsNumber) {
        int batchSize = 6;
        int[] count=new int[8];
        for (int i = 0; i <= randomLottoNumber.size() - batchSize; i += batchSize) {
            List<Integer> currentLottoSet = randomLottoNumber.subList(i, i + batchSize);
            int matchCount = countMatches(currentLottoSet, winsNumber);
            updateCount(count, matchCount);
        }
        return count;
    }
    private static int countMatches(List<Integer> currentLottoSet, List<Integer> winsNumber) {
        int matchCount = 0;
        for (Integer number : currentLottoSet) {
            if (winsNumber.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static void updateCount(int[] count, int matchCount) {
        if (matchCount > 2) {
            count[matchCount]++;
        }
    }
    public static int[] bonusMatches(int bonusNum,List<Integer> randomLottoNumber,int[] count){
        int batchSize = 6;
        for (int i = 0; i <= randomLottoNumber.size() - batchSize; i += batchSize) {
            List<Integer> currentLottoSet = randomLottoNumber.subList(i, i + batchSize);
            if (currentLottoSet.contains(bonusNum)&&(count[5]!=0)) {
                count[5]--;
                count[7]++;
            }
        }
        return count;
    }
}
