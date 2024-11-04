package lotto.lottoapp.model.value;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public enum WinningResult {

    FIRST(1, 2, 1, 6, false, Won.of(2_000_000_000L)),
    SECOND(2, 1, 2, 5, true, Won.of(30_000_000L)),
    THIRD(3, 3, 3, 5, false, Won.of(1_500_000L)),
    FOURTH(4, 4, 4, 4, false, Won.of(50_000L)),
    FIFTH(5, 5, 5, 3, false, Won.of(5_000L)),
    LOSE(6, 6, null, 0, false, Won.of(0L));

    private final int order;
    private final int matchOrder;
    public final Integer ranking;
    public final int minCountOfWinningNumber;
    public final boolean isRequiredWinningBonus;
    public final Won prize;

    WinningResult(int order,
                  int matchOrder,
                  Integer ranking,
                  int minCountOfWinningNumber,
                  boolean isRequiredWinningBonus,
                  Won prize) {
        this.order = order;
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

        long numberForAlreadyGuessedSecondPrize = 1L;
        return Arrays.stream(WinningResult.values())
                .sorted(Comparator.comparing(result -> result.matchOrder))
                .skip(numberForAlreadyGuessedSecondPrize)
                .filter(result -> result.minCountOfWinningNumber <= countOfWinningNumber)
                .findFirst()
                .get(); // 당첨 판정 결과는 반드시 존재한다.
    }

    public static Stream<WinningResult> orderedStream() {
        return Arrays.stream(WinningResult.values())
                .sorted(Comparator.comparing(result -> result.order));
    }

    private static boolean isSecondPrize(int countOfWinningNumber, boolean isWinningBonus) {
        return SECOND.isRequiredWinningBonus == isWinningBonus &&
                SECOND.minCountOfWinningNumber <= countOfWinningNumber;
    }

}
