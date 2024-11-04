package lotto.service.matching;

import lotto.dto.BonusNumberRequestDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.PrizeRank;

import java.util.HashMap;
import java.util.Map;

public class MatchingService {
    private final WinningNumbersRequestDto winningNumbersRequestDto;
    private final BonusNumberRequestDto bonusNumberRequestDto;

    private final Map<PrizeRank, Prize> prizeMap = new HashMap<>();

    public MatchingService(WinningNumbersRequestDto winningNumbersRequestDto, BonusNumberRequestDto bonusNumberRequestDto) {
        this.winningNumbersRequestDto = winningNumbersRequestDto;
        this.bonusNumberRequestDto = bonusNumberRequestDto;

        for (PrizeRank rank : PrizeRank.values()) {
            prizeMap.put(rank, new Prize(rank));
        }
    }

    public int countNumberMatching(Lotto lotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbersRequestDto.getWinningNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumberRequestDto.getBonusNumber());
    }

    public void determineAndCountPrize(Lotto lotto) {
        int matchCount = countNumberMatching(lotto);
        boolean bonusMatch = isBonusNumberMatch(lotto);

        PrizeRank rank = PrizeRank.valueOf(matchCount, bonusMatch);

        // Increment the count for this rank in the prize map
        Prize prize = prizeMap.get(rank);
        if (prize != null) {
            prize.incrementCount();
        }
    }

    // Method to get the prize map for further processing or reporting
    public Map<PrizeRank, Prize> getPrizeMap() {
        return prizeMap;
    }
}
