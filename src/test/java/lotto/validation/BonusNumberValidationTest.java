package lotto.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constants.ErrorMessage.BONUS_NUMBER_ONLY_CAN_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class BonusNumberValidationTest {

    @Test
    @DisplayName("보너스 번호는 숫자")
    void 보너스_번호는_숫자() {
        //given
        String inputNumber = "7";

        //when
        Integer bonusNumber = BonusNumberValidation.parseNumber(inputNumber);

        //then
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호는 숫자가 아니면 예외가 발생한다.")
    void 보너스_번호는_숫자가_아니면_예외가_발생한다() {
        //given
        String inputNumber = "칠";

        //when
        //then
        assertThatThrownBy(() -> BonusNumberValidation.parseNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_ONLY_CAN_NUMBER.getErrorMessage());
    }
}