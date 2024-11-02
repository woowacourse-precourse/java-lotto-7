package lotto.domain.vo;

import java.util.List;

public record LottoNumbers(List<Integer> numbers) {
    private static final int BONUS_MATCH_COUNT = 5;

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public WinningRank match(LottoNumbers winningNumbers, BonusNumber bonus) {
        int matchCount = countMatchingNumbers(winningNumbers);
        return WinningRank.of(matchCount, isBonusMatch(matchCount, bonus));
    }

    private int countMatchingNumbers(LottoNumbers winningNumbers) {
        return (int)numbers.stream()
            .filter(winningNumbers::hasNumber)
            .count();
    }

    private boolean isBonusMatch(int matchCount, BonusNumber bonus) {
        return matchCount == BONUS_MATCH_COUNT && hasNumber(bonus.number());
    }
}
