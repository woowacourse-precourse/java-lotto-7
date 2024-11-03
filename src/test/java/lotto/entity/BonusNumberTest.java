package lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 모든_검증에_통과하여_정상적으로_생성된다() {
        // given
        Integer number = 7;

        // when
        BonusNumber bonusNumber = new BonusNumber(number);

        // then
        assertThat(bonusNumber.number()).isEqualTo(number);
    }

    @Test
    void validateInRange_보너스_번호의_범위가_맞지_않아_검증에_실패한다() {
        // given
        Integer number = 46;

        // when

        // then
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE);
    }

    @Test
    void validateInRange_보너스_번호의_범위가_맞지_않아_검증에_실패한다2() {
        // given
        Integer number = 0;

        // when

        // then
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE);
    }
}