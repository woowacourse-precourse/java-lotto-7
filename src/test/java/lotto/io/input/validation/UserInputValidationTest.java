package lotto.io.input.validation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputValidationTest {

	@DisplayName("구매 금액은 0을 초과한 금액만 허용한다.")
	@ValueSource(strings = {"-1", "0", "1000a"})
	@ParameterizedTest(name = "{0}은 구매 금액으로 허용하지 않는다.")
	void validatePurchaseAmount(String inputPurchaseAmount) {

		// given
		UserInputValidation userInputValidation = new UserInputValidation();

		// when // then
		assertThatThrownBy(() -> userInputValidation.validatePurchaseAmount(inputPurchaseAmount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("당첨 번호는 지정된 구분자를 포함해야한다.")
	@Test
	void validateWinningNumbersDelimiter() {

		// given
		UserInputValidation userInputValidation = new UserInputValidation();
		String inputWinningNumbers = "1.2.3.4.5.6";
		String delimiter = ",";

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateWinningNumbersDelimiter(inputWinningNumbers, delimiter))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("당첨 번호는 6개여야 합니다.")
	@Test
	void validateWinningNumbersWithGreaterThanLottoSize() {

		// given
		UserInputValidation userInputValidation = new UserInputValidation();
		String[] splitWinningNumbers = {"1", "2", "3", "4", "5", "6", "7"};

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateWinningNumbers(splitWinningNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("당첨 번호에 중복은 허용하지 않습니다.")
	@Test
	void validateWinningNumbersWithDuplicatedNumbers() {

		// given
		UserInputValidation userInputValidation = new UserInputValidation();
		String[] splitWinningNumbers = {"1", "1", "3", "4", "5", "6"};

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateWinningNumbers(splitWinningNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("당첨 번호는 1미만의 숫자는 허용하지 않습니다.")
	@Test
	void validateWinningNumbersWithLessThanMinNumber() {

		// given
		UserInputValidation userInputValidation = new UserInputValidation();
		String[] splitWinningNumbers = {"0", "1", "3", "4", "5", "6"};

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateWinningNumbers(splitWinningNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("당첨 번호는 45 초과의 숫자는 허용하지 않습니다.")
	@Test
	void validateWinningNumbersWithGreaterThanMaxNumber() {

		// given
		UserInputValidation userInputValidation = new UserInputValidation();
		String[] splitWinningNumbers = {"1", "2", "3", "4", "5", "46"};

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateWinningNumbers(splitWinningNumbers))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("보너스 번호는 1미만의 숫자는 허용하지 않습니다.")
	@Test
	void validateBonusNumberRangeWithLessThanMinNumber() {

		// given
		UserInputValidation userInputValidation = new UserInputValidation();
		String bonusNumber = "0";

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateBonusNumberRange(bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("보너스 번호는 45 초과의 숫자는 허용하지 않습니다.")
	@Test
	void validateBonusNumberRangeWithGreaterThanMaxNumber() {

		// given
		UserInputValidation userInputValidation = new UserInputValidation();
		String bonusNumber = "46";

		// when // then
		assertThatThrownBy(() -> userInputValidation.validateBonusNumberRange(bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}
}