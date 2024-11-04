package lotto.model;

public record WinningResultDto(
	int matchCount,
	long prize,
	int winningCount
) {

	public static WinningResultDto from(Winning winning, int count) {
		return new WinningResultDto(winning.getCount(), winning.getPrize(), count);
	}
}
