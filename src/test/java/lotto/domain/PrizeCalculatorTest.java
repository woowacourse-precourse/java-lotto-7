package lotto.domain;

import static lotto.domain.Prize.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeCalculatorTest {

	@DisplayName("수익률을 퍼센트로 계산할 수 있다.")
	@Test
	void calculateYieldAsPercentage() {

		// given
		Map<Prize, Integer> matchResult = Map.of(
			FIFTH, 3,
			NOTHING, 7
		);

		PrizeCalculator prizeCalculator = new PrizeCalculator();

		// when
		double resultYield = prizeCalculator.calculateYieldAsPercentage(10_000, matchResult);

		// then
		assertThat(resultYield).isEqualTo(150.00);
	}
}