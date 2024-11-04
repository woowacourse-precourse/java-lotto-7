package lotto.domain.vo;

@FunctionalInterface
public interface WinningCondition {
    boolean isWinningCondition(Integer matchingCount, Boolean bonusMatch);
}
