package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
		int number = 0;
		assertThrows(IllegalArgumentException.class, () -> input.validateNumberRange(number));
	}

	@Test
	@DisplayName("당첨번호가 1-45까지의 입력 검증 테스트")
	void 당첨번호가_1부터_45까지의_입력인지_검증하는_테스트() {
		String numbers = "0,2,3,4,5,45";
		assertThrows(IllegalArgumentException.class, () -> input.validateLuckyNumberRange(numbers));
	}

	@Test
	@DisplayName("당첨번호 입력 6개 검증 테스트")
	void 당첨번호_입력이_6개인지_검증하는_테스트() {
		String numbers = "1,2,3,4,5,6,7";
		assertThrows(IllegalArgumentException.class, () -> input.validateNumberCount(numbers));
	}

	@Test
	@DisplayName("당첨번호가 숫자인지 검증 테스트")
	void 당첨번호가_숫자인지_검증하는_테스트() {
		String numbers = "1,2,3,4,5,짱구";
		assertThrows(IllegalArgumentException.class, () -> input.validateLuckyNumberInteger(numbers));
	}

	@Test
	@DisplayName("입력이 숫자인지 검증 테스트")
	void 입력이_숫자인지_검증하는_테스트() {
		String number = "왁";
		assertThrows(IllegalArgumentException.class, () -> input.validateInteger(number));
	}

	@Test
	@DisplayName("당첨번호에 중복이 존재하는지 검증 테스트")
	void 당첨번호에_중복이_존재하는지_검증하는_테스트() {
		String numbers = "1,2,3,4,5,5";
		assertThrows(IllegalArgumentException.class, () -> input.validateDuplicate(numbers));
	}

	@Test
	@DisplayName("보너스번호가 당첨번호 중에 존재하는지 검증 테스트")
	void 보너스번호가_당첨번호에_중복되는지_검증하는_테스트() {
		List<Integer> numbers = List.of(1,2,3,4,5,6);
		String number = "6";
		assertThrows(IllegalArgumentException.class, () -> input.validateDuplicateBonusNumber(numbers, number));
	}

	@Test
	@DisplayName("입력이 빈 문자열인지 검증 테스트")
	void 입력이_빈_문자열인지_검증하는_테스트() {
		String s = "";
		assertThrows(IllegalArgumentException.class, () -> input.validateEmpty(s));
	}
}
