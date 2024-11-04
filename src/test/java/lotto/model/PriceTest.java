package lotto.model;

import static lotto.model.Winning.FIRST;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {

	@ParameterizedTest
	@DisplayName("구입금액이 금액 단위 조건에 나누어 떨어지고 0보다 크다면 Price 객체를 생성할 수 있다.")
	@ValueSource(ints = {1, 2, 3})
	void 구입금액_단위에_나누어_떨어지며_0보다_큰_금액을_가지는_객체를_생성한다(int multiplier) {
		// given
		int priceDivisibilityUnit = 1000;
		int expectedPrice = priceDivisibilityUnit * multiplier;

		// when
		Price price = new Price(expectedPrice);

		// then
		assertEquals(expectedPrice, price.getPrice());
	}

	@ParameterizedTest
	@DisplayName("구입금액이 금액 단위 조건에 나누어 떨어지지 않는다면 에러를 발생시킨다.")
	@ValueSource(ints = {500, 1234, 999})
	void 구입금액_단위에_나누어_떨어지지_않을_때_예외가_발생한다(int increment) {
		// given
		int priceDivisibilityUnit = 1000;
		int expectedPrice = priceDivisibilityUnit + increment;

		// when, then
		assertThatThrownBy(() -> new Price(expectedPrice))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.");
	}

	@Test
	@DisplayName("구입금액이 0보다 작거나 같다면 에러를 발생시킨다.")
	void 구입금액이_0보다_작거나_같을_때_예외가_발생한다() {
		// given
		int expectedPrice = 0;

		// when, then
		assertThatThrownBy(() -> new Price(expectedPrice))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 구입금액은 0보다 커야 합니다.");
	}

	@Test
	@DisplayName("수익률을 정확하게 계산하고 문자열로 파싱할 수 있다.")
	void 수익률을_정확하게_계산하고_문자열로_파싱한다() {
		// given
		Price price = new Price(1000);
		Map<Winning, Integer> winningResult = Winning.initializeWinningResults();
		winningResult.put(FIRST, 1);
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
		String expectedProfitRate = decimalFormat.format(FIRST.getPrize() / 1000 * 100);

		// when
		String profitRate = price.getProfitRate(winningResult);

		// then
		assertEquals(expectedProfitRate, profitRate);
	}
}