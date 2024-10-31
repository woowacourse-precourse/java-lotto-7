package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.validator.WinningNumbersValidationMessage;

class WinningNumbersTest {

	@DisplayName("당첨 번호와 보너스 번호를 받아 WinningNumbers를 생성한다.")
	@Test
	void of() {
		//given
		List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);
		int inputBonusNumber = 7;

		//when
		WinningNumbers winningNumbers = WinningNumbers.of(inputNumbers, inputBonusNumber);

		//then
		assertThat(winningNumbers).isNotNull();
	}

	@DisplayName("당첨 번호의 개수가 6개가 아니라면 IllegalArgumentException 예외가 발생한다.")
	@MethodSource("invalidSizeProvider")
	@ParameterizedTest
	void ofNotSize(List<Integer> inputNumbers) {
		//given
		int inputBonusNumber = 8;

		//when & then
		assertThatThrownBy(() -> WinningNumbers.of(inputNumbers, inputBonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(WinningNumbersValidationMessage.INVALID_WINNING_NUMBERS_SIZE.getMessage());
	}

	@DisplayName("당첨 번호의 숫자가 1~45 범위에 있지 않으면 IllegalArgumentException 예외가 발생한다.")
	@MethodSource("invalidRangeProvider")
	@ParameterizedTest
	void ofNotInRange(List<Integer> inputNumbers) {
		//given
		int inputBonusNumber = 8;

		//when & then
		assertThatThrownBy(() -> WinningNumbers.of(inputNumbers, inputBonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(WinningNumbersValidationMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage());
	}

	@DisplayName("당첨 번호의 숫자가 중복되었다면 IllegalArgumentException 예외가 발생한다.")
	@MethodSource("invalidDuplicateProvider")
	@ParameterizedTest
	void ofDuplication(List<Integer> inputNumbers) {
		//given
		int inputBonusNumber = 8;

		//when & then
		assertThatThrownBy(() -> WinningNumbers.of(inputNumbers, inputBonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(WinningNumbersValidationMessage.INVALID_WINNING_NUMBERS_DUPLICATION.getMessage());
	}

	@DisplayName("보너스 번호가 1~45 범위에 있지 않으면 IllegalArgumentException 예외가 발생한다.")
	@Test
	void ofBonusNumberNotInRange() {
		//given
		List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);
		int inputBonusNumber = 0;

		//when & then
		assertThatThrownBy(() -> WinningNumbers.of(inputNumbers, inputBonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(WinningNumbersValidationMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
	}

	@DisplayName("당첨 번호와 보너스 번호가 중복되면 IllegalArgumentException 예외가 발생한다.")
	@MethodSource("winningNumbersWithBonusProvider")
	@ParameterizedTest
	void ofWinningNumberWithBonusNumberDuplication(List<Integer> inputNumbers, int inputBonusNumber) {
		//given

		//when & then
		assertThatThrownBy(() -> WinningNumbers.of(inputNumbers, inputBonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(
				WinningNumbersValidationMessage.INVALID_WINNING_NUMBERS_WITH_BONUS_NUMBER_DUPLICATION.getMessage());
	}

	static Stream<List<Integer>> invalidSizeProvider() {
		return Stream.of(
			List.of(1, 2, 3, 4, 5),
			List.of(1, 2, 3, 4, 5, 6, 7)
		);
	}

	static Stream<List<Integer>> invalidRangeProvider() {
		return Stream.of(
			List.of(-1, 0, 1, 2, 3, 4),
			List.of(46, 47, 48, 49, 50, 51),
			List.of(-1, 1, 2, 3, 4, -5)
		);
	}

	static Stream<List<Integer>> invalidDuplicateProvider() {
		return Stream.of(
			List.of(1, 1, 1, 1, 1, 1),
			List.of(1, 2, 3, 4, 4, 5),
			List.of(1, 1, 2, 3, 4, 3)
		);
	}

	static Stream<Arguments> winningNumbersWithBonusProvider() {
		return Stream.of(
			Arguments.of(List.of(1, 2, 3, 4, 5, 6), 1),
			Arguments.of(List.of(1, 2, 3, 4, 5, 6), 3),
			Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
		);
	}
}