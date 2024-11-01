package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constants.ErrorMessage.BONUS_NUMBER_ONLY_CAN_NUMBER;
import static lotto.constants.ErrorMessage.BONUS_NUMBER_ONLY_CAN_RANGE_1_TO_45;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("보너스 번호는 1~45 사이")
    void 보너스_번호는_1_45_사이() {
        //given
        int inputNumber = 7;

        //when
        //then
        BonusNumberValidation.validateRange10To45(inputNumber);
    }

    @Test
    @DisplayName("보너스 번호는 1~45 사이가 아니면 예외가 발생한다.")
    void 보너스_번호는_1_45_사이가_아니면_예외가_발생한다() {
        //given
        int inputNumber = 46;

        //when
        //then
        assertThatThrownBy(() -> BonusNumberValidation.validateRange10To45(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_ONLY_CAN_RANGE_1_TO_45.getErrorMessage());
    }
}