package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.Prize;

public class NumberMatchCounter {
    private static final int COUNT_FOR_BONUS = 5;
    private final Map<Prize, Long> prizeCountMap;
    private final LottoArchive lottoArchive;
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;


    public NumberMatchCounter(LottoArchive lottoArchive, WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.lottoArchive = lottoArchive;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.prizeCountMap = new EnumMap<>(Prize.class);
        initializePrizeCount();
        countPrize();
    }

    private void initializePrizeCount() {
        for (Prize prize : Prize.values()) {
            prizeCountMap.put(prize, 0L);
        }
    }

    private void countPrize() {
        for (Lotto lotto : lottoArchive.getLottos()) {
            Prize prize = checkLotto(lotto.getNumbers());
            if (prize != null) {
                prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
            }
        }
    }

    private Prize checkLotto(List<Integer> numbers) {
        int commonNumberCount = winningNumber.checkSameCount(numbers);
        boolean isBonus = (commonNumberCount == COUNT_FOR_BONUS) && (bonusNumber.checkBonusNumber(numbers));

        for (Prize prize : Prize.values()) {
            if (prize.matches(commonNumberCount, isBonus)) {
                return prize;
            }
        }
        return null;
    }

    public Map<Prize, Long> getPrizeCounts() {
        return prizeCountMap;
    }
}
