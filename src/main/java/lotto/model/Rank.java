package lotto.model;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchingNumbersCount;
    private final int prize;

    Rank(int matchingNumbersCount, int prize) {
        this.matchingNumbersCount = matchingNumbersCount;
        this.prize = prize;
    }

    public static Map<Rank, Integer> findAllCount(Lottos lottos, WinningLotto winningLotto) {
        return Stream.of(Rank.values())
                .collect(
                        Collectors.toMap(
                                rank -> rank,
                                rank -> lottos.countOfRank(rank, winningLotto),
                                (e, r) -> e,
                                LinkedHashMap::new
                        )
                );
    }

    public boolean matches(WinningLotto winningLotto, Lotto lotto) {
        if (this == THIRD) {
            return winningLotto.countMatchingNumbers(lotto) == matchingNumbersCount &&
                    !winningLotto.hasBonusNumber(lotto);
        }
        if (this == SECOND) {
            return winningLotto.countMatchingNumbers(lotto) == matchingNumbersCount &&
                    winningLotto.hasBonusNumber(lotto);
        }
        return winningLotto.countMatchingNumbers(lotto) == matchingNumbersCount;
    }
}
