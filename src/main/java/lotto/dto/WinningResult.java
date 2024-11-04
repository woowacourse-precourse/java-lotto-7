package lotto.dto;

public record WinningResult(
        int threeMatchesCount,
        int fourMatchesCount,
        int fiveMatchesCount,
        int fiveWithBonusCount,
        int sixMatchesCount,
        double totalYield
) {

}
