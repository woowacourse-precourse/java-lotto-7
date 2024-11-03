package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.validator.InputValidationMessage;

class AmountTest {
	@DisplayName("Amount를 생성한다.")
	@Test
	void of() {
		//given
		int input = 1000;

		//when
		Amount amount = Amount.of(input);

		//then
		assertThat(amount).isNotNull();
	}

	@DisplayName("입력값이 1000으로 나누어 떨어지지 않으면 IllegalArgumentException 예외가 발생한다.")
	@MethodSource("invalidNumbers")
	@ParameterizedTest
	void ofNotDivisible(int input) {
		//given

		//when & then
		assertThatThrownBy(() -> Amount.of(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputValidationMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
	}

	static Stream<Integer> invalidNumbers() {
		return Stream.of(999, 1001, 1234, 9999, 10001);
	}
}
