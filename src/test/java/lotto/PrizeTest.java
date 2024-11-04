package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class PrizeTest {

	@ParameterizedTest
	@MethodSource("winningPrizeResult")
	void 로또_당첨_당첨금_확인_테스트(int matchCount, boolean bonus, long prizeAmount) {
		Prize first = Prize.rank(matchCount, bonus);

		assertThat(first.getAmount()).isEqualTo(prizeAmount);
	}

	static Stream<Arguments> winningPrizeResult() {
		return Stream.of(
				Arguments.arguments(6, false, 2_000_000_000),
				Arguments.arguments(5, true, 30_000_000),
				Arguments.arguments(5, false, 1_500_000),
				Arguments.arguments(4, false, 50_000),
				Arguments.arguments(3, false, 5_000)
		);
	}
}
