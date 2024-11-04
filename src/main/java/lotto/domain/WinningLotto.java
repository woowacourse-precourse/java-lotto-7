package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        validateDuplicateNumber(numbers,bonusNumber);
        this.winningNumbers = new Lotto(numbers).getNumbers();
        this.bonusNumber = bonusNumber;
    }

    private Map<LottoRank, Integer> initializeMap(){
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        for(LottoRank rank: LottoRank.values()){
            if(rank != LottoRank.NONE){
                rankCount.put(rank, 0);
            }
        }
        return rankCount;
    }

    public Map<LottoRank, Integer> countLottoRankings(List<List<Integer>> lotteries){
        Map<LottoRank, Integer> rankCount = initializeMap();
        for (List<Integer> lotto : lotteries){
            int winningCount = countWinningNumbers(lotto);
            boolean isBonusMatch = countBonusNumbers(lotto);
            LottoRank rank = LottoRank.valueOf(winningCount,isBonusMatch);
            if(rank != LottoRank.NONE){
                rankCount.put(rank,rankCount.get(rank)+1);
            }
        }
        return rankCount;
    }
    public int countWinningNumbers(List<Integer> lotto) {
        int winningCount = 0;
        for (Integer number : winningNumbers) {
            if (matchWinningBonusNumber(lotto, number)) {
                //System.out.println("당첨" + number);
                winningCount++;
            }
        }
        return winningCount;
    }

    public boolean countBonusNumbers(List<Integer> lotto) {
        return matchWinningBonusNumber(lotto, bonusNumber);
    }

    private boolean matchWinningBonusNumber(List<Integer> numbers, int targetNumber) {
        // 정렬 안해서 바이너리 서치 말고 선형 서치 선택
        return numbers.contains(targetNumber);
    }

    public long calculateTotalWinnings(Map<LottoRank, Integer> rankCount){
        long totalWinMoney = 0L;
        for(Map.Entry<LottoRank,Integer> entry: rankCount.entrySet()){
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            totalWinMoney += (long) rank.getPrize() * count;
        }
        return totalWinMoney;
    }
    public double calculateRate(long totalWinMoney, long payment){
        return Math.round(((double) totalWinMoney / payment) * 10) / 10.0;
    }

    private void validateDuplicateNumber(List<Integer> winningNumbers, int bonusNumber){
        if(winningNumbers.stream().anyMatch(n -> n.equals(bonusNumber))){
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호가 중복됩니다.");
        }
    }
}
