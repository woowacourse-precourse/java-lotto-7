package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("1보다 작은 로또 번호는 허용하지 않는다")
	@Test
	void validateNumbersRangeWithLessThanMinNumber() {

		// given
		List<Integer> testNumbers = List.of(0, 2, 3, 4, 5, 6);

		// when // then
		assertThatThrownBy(() -> new Lotto(testNumbers))
			.isInstanceOf(IllegalStateException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("45보다 큰 로또 번호는 허용하지 않는다")
	@Test
	void validateNumbersRangeWithGreaterThanMaxNumber() {

		// given
		List<Integer> testNumbers = List.of(1, 2, 3, 4, 5, 46);

		// when // then
		assertThatThrownBy(() -> new Lotto(testNumbers))
			.isInstanceOf(IllegalStateException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("로또를 생성할 수 있다.")
	@Test
	void createLotto() {

		// given
		List<Integer> testNumbers = List.of(1, 2, 11, 21, 44, 45);

		// when // then
		assertDoesNotThrow(() -> new Lotto(testNumbers));
	}
}
