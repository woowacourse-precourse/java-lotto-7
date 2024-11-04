package lotto.model;

import static lotto.model.Winning.FIFTH;
import static lotto.model.Winning.FIRST;
import static lotto.model.Winning.FOURTH;
import static lotto.model.Winning.NONE;
import static lotto.model.Winning.SECOND;
import static lotto.model.Winning.THIRD;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import camp.nextstep.edu.missionutils.Randoms;

class WinningTest {

	@ParameterizedTest
	@DisplayName("매칭 개수와 보너스 번호 일치 여부를 통해 객체를 반환할 수 있다")
	@MethodSource("provideAllCasesWinning")
	void 매칭_개수와_보너스_번호_일치_여부를_통해_객체를_반환한다(int count, boolean hasBonusNumber, Winning winning) {
		// when
		Winning winningResult = Winning.getWinningResult(count, hasBonusNumber);

		// then
		assertEquals(winning, winningResult);
	}

	@Test
	@DisplayName("총 상금을 정확하게 반환할 수 있다.")
	void 총_상금을_정확하게_반환한다() {
		// given
		Map<Winning, Integer> winningResult = Winning.initializeWinningResults();
		int count = Randoms.pickUniqueNumbersInRange(1, 10, 1).getFirst();
		winningResult.put(FIRST, count);

		// when
		long totalWinningPrize = Winning.getTotalWinningPrize(winningResult);

		// then
		assertEquals(FIRST.getPrize() * count, totalWinningPrize);
	}

	private static Stream<Arguments> provideAllCasesWinning() {
		return Stream.of(
				Arguments.of(6, false, FIRST),
				Arguments.of(5, true, SECOND),
				Arguments.of(5, false, THIRD),
				Arguments.of(4, false, FOURTH),
				Arguments.of(3, false, FIFTH),
				Arguments.of(2, false, NONE),
				Arguments.of(1, false, NONE),
				Arguments.of(0, false, NONE)
		);
	}

}