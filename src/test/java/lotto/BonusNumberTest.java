package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_CONFLICT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @Test
    @DisplayName("보너스번호가 당첨번호와 중복될 경우 예외가 발생한다.")
    void 보너스번호가_당첨번호와_중복될_경우_예외발생() {

        Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber(1, testLotto.getNumbers()))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(BONUS_NUMBER_CONFLICT.getValue());
    }
}
