package lotto.validator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatingParserTest {
	@DisplayName("구입 금액을 숫자로 반환한다.")
	@Test
	void validatePurchaseAmount() {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();
		String input = "1000";
		int expect = 1000;

		//when
		int result = validatingParser.validatePurchaseAmount(input);

		//then
		assertThat(result).isEqualTo(expect);
	}

	@DisplayName("구입 금액이 숫자가 아니면 IllegalArgumentException 예외가 발생한다.")
	@CsvSource({
		"10a0",
		"test",
		"%#@!$)",
		"''",
		"' '",
	})
	@ParameterizedTest
	void validatePurchaseAmountNotNumber(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();

		//when & then
		assertThatThrownBy(() -> validatingParser.validatePurchaseAmount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputValidationMessage.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());
	}

	@DisplayName("구입 금액이 int의 최대 범위를 초과하면 IllegalArgumentException 예외가 발생한다.")
	@CsvSource({
		"21500000000",
		"100000000000"
	})
	@ParameterizedTest
	void validatePurchaseAmountOverFlow(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();

		//when & then
		assertThatThrownBy(() -> validatingParser.validatePurchaseAmount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputValidationMessage.INVALID_PURCHASE_AMOUNT_OVER_FLOW.getMessage());
	}

	@DisplayName("구입 금액이 양수가 아니면 IllegalArgumentException 예외가 발생한다.")
	@CsvSource({
		"0",
		"-1",
	})
	@ParameterizedTest
	void validatePurchaseAmountNotPositiveNumber(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();

		//when & then
		assertThatThrownBy(() -> validatingParser.validatePurchaseAmount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputValidationMessage.INVALID_PURCHASE_AMOUNT_NEGATIVE.getMessage());
	}

	@DisplayName("쉼표(,)로 구분된 문자열을 숫자 번호 목록으로 반환한다.")
	@Test
	void validateWinningNumbers() {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();
		String input = "1,2,3,4,5,6";
		List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);

		//when
		List<Integer> result = validatingParser.validateWinningNumbers(input);

		//then
		assertThat(expect).isEqualTo(result);
	}

	@DisplayName("쉼표(,)로 문자가 구분되지 않으면 IllegalArgumentException 예외가 발생한다.")
	@CsvSource({
		"123456",
		"12 34 56",
		"1 2 3 4 5 6"
	})
	@ParameterizedTest
	void validateWinningNumbersNotHasDelimiter(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();

		//when & then
		assertThatThrownBy(() -> validatingParser.validateWinningNumbers(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputValidationMessage.MISSING_WINNING_NUMBERS_DELIMITER.getMessage());
	}

	@DisplayName("각 문자열이 숫자가 아니면 IllegalArgumentException 예외가 발생한다.")
	@CsvSource({
		"'a,b,c,d,e,f'",
		"'1,a,b,4,5,6'",
		"'@,1,2,3,4,^'"
	})
	@ParameterizedTest
	void validateWinningNumbersNotNumber(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();

		//when & then
		assertThatThrownBy(() -> validatingParser.validateWinningNumbers(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputValidationMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
	}

	@DisplayName("각 문자열이 int의 최대 범위를 초과하면 IllegalArgumentException 예외가 발생한다.")
	@CsvSource({
		"'1,21500000000,3,4,5,6'",
		"'1,2,3,4,5,100000000000'"
	})
	@ParameterizedTest
	void validateWinningNumbersOverFlow(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();

		//when & then
		assertThatThrownBy(() -> validatingParser.validateWinningNumbers(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputValidationMessage.INVALID_WINNING_NUMBERS_OVER_FLOW.getMessage());
	}

	@DisplayName("보너스 번호를 숫자로 반환한다.")
	@Test
	void validateBonusNumber() {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();
		String input = "1";
		int expect = 1;

		//when
		int result = validatingParser.validateBonusNumber(input);

		//then
		assertThat(result).isEqualTo(expect);
	}

	@DisplayName("보너스 번호가 숫자가 아니면 IllegalArgumentException 예외가 발생한다.")
	@CsvSource({
		"a",
		"abcd",
		"%#@!$)",
		"''",
		"' '",
	})
	@ParameterizedTest
	void validateBonusNumberNotNumber(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();

		//when & then
		assertThatThrownBy(() -> validatingParser.validateBonusNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputValidationMessage.INVALID_BONUS_NUMBER_FORMAT.getMessage());
	}

	@DisplayName("보너스 번호가 양수가 아니면 IllegalArgumentException 예외가 발생한다.")
	@CsvSource({
		"0",
		"-1",
	})
	@ParameterizedTest
	void validateBonusNotPositiveNumber(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();

		//when & then
		assertThatThrownBy(() -> validatingParser.validateBonusNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputValidationMessage.INVALID_BONUS_NUMBER_NEGATIVE.getMessage());
	}

	@DisplayName("보너스 번호가 int의 최대 범위를 초과하면 IllegalArgumentException 예외가 발생한다.")
	@CsvSource({
		"21500000000",
		"100000000000"
	})
	@ParameterizedTest
	void validateBonusNumberOverFlow(String input) {
		//given
		ValidatingParser validatingParser = ValidatingParser.getInstance();

		//when & then
		assertThatThrownBy(() -> validatingParser.validateBonusNumber(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputValidationMessage.INVALID_BONUS_NUMBER_OVER_FLOW.getMessage());
	}
}
