package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

class InputValidatorTest {

	@Nested
	class 자연수_입력Test{
		@Test
		void 성공() {
			String input = "1";
			assertThatNoException()
					.isThrownBy(() -> InputValidator.validateNaturalNumber(input));
		}

		@ParameterizedTest
		@NullAndEmptySource
		void 실패_null_혹은_빈값(String input) {
			assertThatIllegalArgumentException()
					.isThrownBy(() -> InputValidator.validateNaturalNumber(input));
		}

		@ParameterizedTest
		@ValueSource(strings = {"a", "-1", "0"})
		void 실패_자연수가_아닌_수(String input) {
			assertThatIllegalArgumentException()
					.isThrownBy(() -> InputValidator.validateNaturalNumber(input));
		}
	}

	@Nested
	class 구매_가능_금액Test {
		@ParameterizedTest
		@ValueSource(ints = {1000, 100_000})
		void 성공(int money) {
			assertThatNoException()
					.isThrownBy(() -> InputValidator.validatePurchasable(money));
		}

		@ParameterizedTest
		@ValueSource(ints = {900, 110_000})
		void 실패_천원단위가_아니거나_십만원_초과(int money) {
			assertThatIllegalArgumentException()
					.isThrownBy(() -> InputValidator.validatePurchasable(money));
		}
	}

	@Nested
	class 로또_번호_구분자Test {
		@Test
		void 성공() {
			String input = "1,2,3,4,5,6";

			assertThatNoException()
					.isThrownBy(() -> InputValidator.validateContainsDelimiter(input));
		}

		@Test
		void 실패_구분자_미포함() {
			String input = "123456";

			assertThatIllegalArgumentException()
					.isThrownBy(() -> InputValidator.validateContainsDelimiter(input));
		}
	}

	@Nested
	class 추첨_번호_개수Test {
		@Test
		void 성공() {
			List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

			assertThatNoException()
					.isThrownBy(() -> InputValidator.validateSixNumbers(numbers));
		}

		@ParameterizedTest
		@MethodSource("numbersCount")
		void 실패_6개_아님(List<Integer> numbers) {
			assertThatIllegalArgumentException()
					.isThrownBy(() -> InputValidator.validateSixNumbers(numbers));
		}

		static Stream<Arguments> numbersCount() {
			return Stream.of(
					Arguments.arguments(List.of(1, 2, 3, 4, 5)),
					Arguments.arguments(List.of(1, 2, 3, 4, 5, 6, 7))
			);
		}
	}

	@Nested
	class 당첨_번호_중복Test {
		@Test
		void 성공() {
			List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

			assertThatNoException()
					.isThrownBy(() -> InputValidator.validateWinningNumbersDuplicate(winningNumbers));
		}

		@Test
		void 실패() {
			List<Integer> winningNumbers = List.of(1, 2, 3, 4, 4, 5);

			assertThatIllegalArgumentException()
					.isThrownBy(() -> InputValidator.validateWinningNumbersDuplicate(winningNumbers));
		}
	}

	@Nested
	class 보너스_번호_중복Test {
		@Test
		void 성공() {
			List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
			int bonusNumber = 7;

			assertThatNoException()
					.isThrownBy(() -> InputValidator.validateBonusNotInWinningNumbers(winningNumbers, bonusNumber));
		}

		@Test
		void 실패() {
			List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
			int bonusNumber = 5;

			assertThatIllegalArgumentException()
					.isThrownBy(() -> InputValidator.validateBonusNotInWinningNumbers(winningNumbers, bonusNumber));
		}
	}

	@Nested
	class 추첨_번호_범위Test {
		@ParameterizedTest
		@ValueSource(strings = {"1", "10", "45"})
		void 성공(String number) {
			assertThatNoException()
					.isThrownBy(() -> InputValidator.validateNumberInLottoRange(number));

		}

		@ParameterizedTest
		@ValueSource(strings = {"0", "46"})
		void 실패(String number) {
			assertThatIllegalArgumentException()
					.isThrownBy(() -> InputValidator.validateNumberInLottoRange(number));
		}
	}
}
