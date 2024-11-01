package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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
}