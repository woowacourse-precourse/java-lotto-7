package lotto.validation;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.ErrorMessage.*;
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

    @Test
    @DisplayName("보너스 번호는 로또번호와 중복되지 않는다.")
    void 보너스_번호는_로또번호와_중복되지_않는다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int bonusNumber = 7;

        //then
        BonusNumberValidation.validateDuplication(lotto, bonusNumber);
    }

    @Test
    @DisplayName("보너스 번호는 로또번호와 중복이면 예외가 발생한다.")
    void 보너스_번호는_로또번호와_중복이면_예외가_발생한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int bonusNumber = 4;

        //then
        assertThatThrownBy(() -> BonusNumberValidation.validateDuplication(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_CAN_NOT_BE_DUPLICATED_LOTTO_NUMBER.getErrorMessage());

    }
}