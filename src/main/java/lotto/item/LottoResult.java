package lotto.item;

import lotto.Lotto;
import lotto.common.WinningRank;

import java.util.*;

import static lotto.common.WinningRank.*;

public class LottoResult {
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Lotto> lottos;
    private Map<WinningRank, Integer> winningRankInfo;
    private int winningAmount;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
        initializeWinningRankInfo();
    }

    public Integer getTotalWinningAmounts() {
        getWinningResult();
        int sum = 0;
        List<WinningRank> winningRanks = winningRankInfo.keySet().stream().toList();

        for(WinningRank winningRank : winningRanks) {
            int amount = winningRank.getWinningAmount();
            int count = winningRankInfo.get(winningRank);
            sum += amount * count;
        }
        winningAmount = sum;

        return winningAmount;
    }

    public Map<WinningRank, Integer> getWinningResult() {
        initializeWinningRankInfo();
        for(Lotto lotto : lottos) {
            int matchedCount = getMatchedCount(lotto, winningNumbers);
            WinningRank winningRank = WinningRank.determine(matchedCount,
                    isMatchedBonusNumber(lotto, bonusNumber));
            winningRankInfo.put(winningRank, winningRankInfo.get(winningRank)+1);
        }
        return winningRankInfo;
    }

    public void printWinningResult() {
        getWinningResult();

        List<WinningRank> winningRanks = new ArrayList<>(winningRankInfo.keySet());
        winningRanks.sort(Comparator.comparing(WinningRank::getWinningAmount));
        winningRanks.remove(NOT_IN_PLACE);

        System.out.println("\n당첨 통계\n---");
        for(WinningRank winningRank : winningRanks) {
            System.out.println(winningRank.getMatchedCount() + "개 일치" + winningRank.getPhraseIfMatchedBonusNumber()
                    + " (" + winningRank.getWinningAmountInfo() + ") - " + winningRankInfo.get(winningRank) + "개");
        }
    }

    private void initializeWinningRankInfo() {
        winningRankInfo = new HashMap<>();
        winningRankInfo.put(FIRST_PLACE, 0);
        winningRankInfo.put(SECOND_PLACE, 0);
        winningRankInfo.put(THIRD_PLACE, 0);
        winningRankInfo.put(FOURTH_PLACE, 0);
        winningRankInfo.put(FIFTH_PLACE, 0);
        winningRankInfo.put(NOT_IN_PLACE, 0);
    }

    private Integer getMatchedCount(Lotto lotto, List<Integer> winningNumbers) {
        // 제거된 개수 == 맞춘 개수
        List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
        int matchedCount = lottoNumbers.size();
        lottoNumbers.removeAll(winningNumbers);
        matchedCount -= lottoNumbers.size();

        return matchedCount;
    }

    private boolean isMatchedBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if(lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}