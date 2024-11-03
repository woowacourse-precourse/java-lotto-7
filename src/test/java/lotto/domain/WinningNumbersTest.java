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
	@DisplayName("당첨 번호와 보너스 번호를 받아 당첨번호 목록을 생성한다.")
	@Test
	void of() {
		//given
		MainWinningNumbers mainWinningNumbers = MainWinningNumbers.from(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonusNumber = BonusNumber.from(7);

		//when
		WinningNumbers winningNumbers = WinningNumbers.of(mainWinningNumbers, bonusNumber);

		//then
		assertThat(winningNumbers).isNotNull();
	}

	@DisplayName("당첨 번호와 보너스 번호가 중복되면 IllegalArgumentException 예외가 발생한다.")
	@MethodSource("winningNumbersWithBonusProvider")
	@ParameterizedTest
	void ofMainWinningNumberWithBonusNumberDuplication(List<Integer> inputNumbers, int inputBonusNumber) {
		//given
		MainWinningNumbers mainWinningNumbers = MainWinningNumbers.from(inputNumbers);
		BonusNumber bonusNumber = BonusNumber.from(inputBonusNumber);

		//when & then
		assertThatThrownBy(() -> WinningNumbers.of(mainWinningNumbers, bonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(
				WinningNumbersValidationMessage.INVALID_WINNING_NUMBERS_WITH_BONUS_NUMBER_DUPLICATION.getMessage());
	}

	static Stream<Arguments> winningNumbersWithBonusProvider() {
		return Stream.of(
			Arguments.of(List.of(1, 2, 3, 4, 5, 6), 1),
			Arguments.of(List.of(1, 2, 3, 4, 5, 6), 3),
			Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
		);
	}
}
