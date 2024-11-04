package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JudgementNumberTest {
	JudgementNumber judgementNumber = new JudgementNumber();

	@ParameterizedTest
	@DisplayName("유효한 범위의 숫자인가")
	@ValueSource(ints = {1, 40})
	void isValidRange(int number) {
		assertThat(judgementNumber.judgementRange(number)).isTrue();
	}

}