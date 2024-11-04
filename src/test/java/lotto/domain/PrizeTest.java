package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {
	@DisplayName("맞춘 당첨 번호 개수와 보너스 번호를 맞췄는지 여부를 기반으로 당첨 결과를 조회할 수 있다.")
	@CsvSource({
		"0, true, NOTHING",
		"2, true, NOTHING",
		"3, true, FIFTH",
		"3, false, FIFTH",
		"5, true, SECOND",
		"5, false, THIRD"
	})
	@ParameterizedTest(name = "{0}개의 당첨 번호를 맞추고 보너스가 {1}인 경우, {2}이다.")
	void valueOfWinningNumberHitCountAndBonusHit(int winningNumberHitCount, boolean isBonusHit, Prize expect) {

		// when
		Prize result = Prize.valueOfWinningNumberHitCountAndBonusHit(winningNumberHitCount, isBonusHit);

		// then
		assertThat(result).isEqualTo(expect);

	}

}