package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.validator.WinningNumbersValidationMessage;

class BonusNumberTest {
	@DisplayName("번호를 받아 보너스 번호를 생성한다.")
	@Test
	void from() {
		//given
		int inputBonusNumber = 1;

		//when
		BonusNumber bonusNumber = BonusNumber.from(inputBonusNumber);

		//then
		assertThat(bonusNumber).isNotNull();
	}

	@DisplayName("보너스 번호가 1~45 범위에 있지 않으면 IllegalArgumentException 예외가 발생한다.")
	@Test
	void ofBonusNumberNotInRange() {
		//given
		int inputBonusNumber = 46;

		//when & then
		assertThatThrownBy(() -> BonusNumber.from(inputBonusNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(WinningNumbersValidationMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
	}
}
