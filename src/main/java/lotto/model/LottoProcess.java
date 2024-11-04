package lotto.model;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.WinnerPrice;
import java.util.*;

public class LottoProcess {
    private List<Integer> winningStatistics;

    public LottoProcess() {
        winningStatistics = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }


    public List<Integer> getWinningStatistics() {
        return this.winningStatistics;
    }

    public void addWinningStatisticValue(int index) {
        Integer winningStatisticValue = this.winningStatistics.get(index);
        this.winningStatistics.set(index, winningStatisticValue + 1);
    }

    public List<Integer> getRandomLottoNumbers() {
        List<Integer> immutableLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoNumbers = new ArrayList<>(immutableLottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }


    //로또 번호랑 당첨 번호, 보너스번호 겹치는 개수를 통해 당첨 통계 리스트에 반영하는 메소드
    public void reflectWinningCountToStatistics(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {

        int countMatch = calculateWinningCount(lottoNumbers, winningNumbers);
        boolean isBonusNumberMatch = isBonusNumberInLottoNumbers(lottoNumbers, bonusNumber);
        int winnerStatisticsIndex = WinnerPrice.getWinnerStatisticsIndexByCountMatch(countMatch, isBonusNumberMatch);
        if (winnerStatisticsIndex != -1) {
            addWinningStatisticValue(winnerStatisticsIndex);

        }

    }
    //로또 번호랑 당첨 번호랑 겹치는 개수 반환
    public int calculateWinningCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumbers);
        lottoNumberSet.retainAll(winningNumbers);
        return lottoNumberSet.size();
    }

    //보너스 볼이 당첨 번호 안에 포함 되는지 여부 반환
    public boolean validateBonusNumberInWinningNumbersInLottoProcess(int bonusNumber, List<Integer> winningNumbers) {
        return winningNumbers.contains(bonusNumber);
    }

    //보너스 볼이 로또 안에 포함 되는지 여부 반환
    public boolean isBonusNumberInLottoNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    //총 수익금 계산
    public long calculateProfit() {
        long profit = 0;
        int winnerStatisticsIndex = 4;
        for (WinnerPrice winnerPrice : WinnerPrice.values()) {
            profit += (long) winnerPrice.getPrize() * winningStatistics.get(winnerStatisticsIndex--);

        }
        return profit;
    }

    //수익률 계산
    public double calculateProfitRate(int purchaseAmount) {
        long profit = calculateProfit();
        return ((double) profit / purchaseAmount) * 100;
    }

}
