package lotto.service;

import lotto.utils.LottoCriteria;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.LottoCriteria.NONE;
import static lotto.utils.LottoCriteria.SECOND;
import static lotto.utils.LottoCriteria.THIRD;

public class Lotto {
    private final static int MATCH_COUNT_SECOND_THIRD = 5;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public Integer draw(List<Integer> winningNumbers, Integer bonusNumber) {
        long matchCount = getMatchCount(winningNumbers);
        boolean matchBonus = isMatchBonus(bonusNumber);

        return getRankByMatchCountAndBonus(matchCount, matchBonus);
    }

    private long getMatchCount(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean isMatchBonus(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private static int getRankByMatchCountAndBonus(long matchCount, boolean isMatchBonus) {
        if (matchCount == MATCH_COUNT_SECOND_THIRD) {
            return checkBonus(isMatchBonus);
        }
        return checkRank(matchCount);
    }

    private static int checkBonus(boolean isMatchBonus) {
        if (isMatchBonus) return SECOND.getRank();
        return THIRD.getRank();
    }

    private static int checkRank(long matchCount) {
        return Arrays.stream(LottoCriteria.values())
                .filter(criteria -> matchCount == criteria.getMatchCount())
                .findFirst()
                .map(LottoCriteria::getRank)
                .orElse(NONE.getRank());
    }
}
