package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
	Input input;
	@BeforeEach
	void setUp() {
		input = new Input();
	}

	@Test
	@DisplayName("구입 금액 입력 검증 테스트")
	void 구입_금액이_1000원_단위로_나누어_떨어지는지_검증하는_테스트() {
		String payment = "1400";
		assertThrows(IllegalArgumentException.class, () -> input.validateRemainder(payment));
	}

	@Test
	@DisplayName("번호가 1-45까지의 입력 검증 테스트")
	void 입력이_1부터_45까지의_번호인지_검증하는_테스트() {
		String numbers = "1,2,3,4,5,46";
		assertThrows(IllegalArgumentException.class, () -> input.validateLuckyNumberRange(numbers));
	}
}
