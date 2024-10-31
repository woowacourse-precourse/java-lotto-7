package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("BonusNumber를 생성할 수 있다.")
    @Test
    void createBonusNumber() {
        //given
        int number = 1;

        //when
        BonusNumber bonusNumber = BonusNumber.from(number);

        //then
        assertThat(bonusNumber).isEqualTo(BonusNumber.from(number));
    }

    @DisplayName("보너스 번호의 범위가 1 부터 45 까지의 범위가 아니라면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void outOfRangeBonusNumber(int bonusNumber) {
        //when //then
        assertThatThrownBy(() -> BonusNumber.from(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE.getErrorMessage());
    }
}
