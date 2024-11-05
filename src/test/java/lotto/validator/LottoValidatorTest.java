package lotto.validator;

import lotto.service.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.Constants.LOTTO_DUPLICATE_NUMBER_ERROR;
import static lotto.constants.Constants.LOTTO_NUMBER_RANGE_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class LottoValidatorTest {

	@Test
	@DisplayName("로또 번호에 유효 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
	void 로또_번호가_유효_범위를_벗어나면_예외가_발생한다() {
		List<Integer> outOfRangeNumbers = List.of(0, 2, 3, 4, 5, 46);
		assertThatThrownBy(() -> LottoValidator.judgement(outOfRangeNumbers))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(LOTTO_NUMBER_RANGE_ERROR);
	}

	@Test
	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
		List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 5);
		assertThatThrownBy(() -> LottoValidator.judgement(duplicateNumbers))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(LOTTO_DUPLICATE_NUMBER_ERROR);
	}

	@Test
	@DisplayName("유효한 로또 번호가 입력되었을 때 예외가 발생하지 않는다.")
	void 유효한_로또_번호가_입력되었을_때_예외가_발생하지_않는다() {
		List<Integer> validNumbers = List.of(5, 8, 12, 23, 34, 42);
		assertThatCode(() -> LottoValidator.judgement(validNumbers))
				.doesNotThrowAnyException();
	}
}
