package lotto;

public record Result(
		int fifth,
		int fourth,
		int third,
		int second,
		int first,
		double prizeRate
){
	private static final String FORMAT =
			"""
			\n당첨 통계
			---
			3개 일치 (5,000원) - %s개
			4개 일치 (50,000원) - %s개
			5개 일치 (1,500,000원) - %s개
			5개 일치, 보너스 볼 일치 (30,000,000원) - %s개
			6개 일치 (2,000,000,000원) - %s개
			총 수익률은 %.1f%%입니다.
			""";

	public String formatted() {
		return FORMAT.formatted(
				this.fifth,
				this.fourth,
				this.third,
				this.second,
				this.first,
				this.prizeRate
		);
	}
}
