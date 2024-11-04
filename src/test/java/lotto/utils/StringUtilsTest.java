package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.common.ErrorMessage;

class StringUtilsTest {

	@DisplayName("toNumber 테스트")
	@Nested
	class ToNumberTest {
		@DisplayName("문자열을 숫자로 변환에 성공한다.")
		@ParameterizedTest
		@ValueSource(strings = {"1000", "10000", "100000"})
		void success(String s) {
			int number = StringUtils.toNumber(s);
			assertThat(number).isInstanceOf(Integer.class);
		}

		@DisplayName("문자열을 숫자로 변환에 실패하면 예외를 던진다.")
		@ParameterizedTest
		@ValueSource(strings = {"천원", "!@#$%^", "ABCD", "1000j"})
		void fail(String s) {
			assertThatThrownBy(() -> StringUtils.toNumber(s))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.NON_NUMERIC_INPUT.getMessage());
		}
	}
}