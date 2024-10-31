package lotto.value;

import java.util.Arrays;
import java.util.Comparator;

public enum WinningResult {

    FIRST(2, 1, 6, false, 2_000_000_000L),
    SECOND(1, 2, 5, true, 30_000_000L),
    THIRD(3, 3, 5, false, 1_500_000L),
    FOURTH(4, 4, 4, false, 50_000L),
    FIFTH(5, 5, 3, false, 5_000L),
    LOSE(6, null, 0, false, 0L);

    private final int matchOrder;
    private final Integer ranking;
    private final int minCountOfWinningNumber;
    private final boolean isRequiredWinningBonus;
    private final long prize;

    WinningResult(int matchOrder, Integer ranking, int minCountOfWinningNumber, boolean isRequiredWinningBonus,
                  long prize) {
        this.matchOrder = matchOrder;
        this.ranking = ranking;
        this.minCountOfWinningNumber = minCountOfWinningNumber;
        this.isRequiredWinningBonus = isRequiredWinningBonus;
        this.prize = prize;
    }

    public static WinningResult matchBy(int countOfWinningNumber, boolean isWinningBonus) {
        if (isSecondPrize(countOfWinningNumber, isWinningBonus)) {
            return SECOND;
        }

        return Arrays.stream(WinningResult.values())
                .sorted(Comparator.comparing(result -> result.matchOrder))
                .skip(1L)
                .filter(result -> result.minCountOfWinningNumber <= countOfWinningNumber)
                .findFirst()
                .get(); // 당첨 판정 결과는 반드시 존재한다.
    }

    private static boolean isSecondPrize(int countOfWinningNumber, boolean isWinningBonus) {
        return SECOND.isRequiredWinningBonus == isWinningBonus &&
                SECOND.minCountOfWinningNumber <= countOfWinningNumber;
    }

}
