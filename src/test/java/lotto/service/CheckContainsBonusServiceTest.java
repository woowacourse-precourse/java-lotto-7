package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static lotto.constants.ErrorMessage.LOTTO_NUMBERS_CAN_NOT_BE_DUPLICATED;

import java.util.Arrays;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckContainsBonusServiceTest {

    @DisplayName("입력받은 보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    public void ThrowExceptionIfDuplicatedNumber() {
        // given
        Lotto winning = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("3");
        CheckContainsBonusService checkContainsBonusService = new CheckContainsBonusService();

        // when
        Throwable thrown = catchThrowable(()-> {
            checkContainsBonusService.validateWinningContainsBonus(winning, bonusNumber);
        });

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBERS_CAN_NOT_BE_DUPLICATED.get());
    }
}
