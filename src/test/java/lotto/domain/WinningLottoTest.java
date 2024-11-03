package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constants.ErrorMessage.ERROR_BONUS_NUMBER_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    void 당첨번호와_보너스번호가_중복될경우_예외가_발생한다() {
        assertThatThrownBy(() -> WinningLotto.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_BONUS_NUMBER_DUPLICATE.getMessage());
    }
}
