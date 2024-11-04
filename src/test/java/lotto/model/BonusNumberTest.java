package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static lotto.constants.ErrorMessage.INPUT_CAN_NOT_BE_BLANK;
import static lotto.constants.ErrorMessage.LOTTO_CAN_NOT_HAVE_CHARACTER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class BonusNumberTest {

    @DisplayName("입력받은 값이 빈 값이면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource // given
    public void ThrowExceptionIfBlank(String inputNumber) {
        // when
        Throwable thrown = catchThrowable(() -> {
            BonusNumber bonusNumber = new BonusNumber(inputNumber);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_CAN_NOT_BE_BLANK.get());
    }

    @DisplayName("입력받은 값이 문자를 포함하면 예외가 발생한다.")
    @Test
    public void ThrowExceptionIfHasCharacter(){
        // given
        String inputNumber = "-3";

        // when
        Throwable thrown = catchThrowable(() -> {
            BonusNumber bonusNumber = new BonusNumber(inputNumber);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_CAN_NOT_HAVE_CHARACTER.get());

    }


}
