package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constants.ErrorMessages;
import org.junit.jupiter.api.Test;

public class UserLottoTest {

    Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    int testBonus = 6;

    @Test
    void 보너스번호와_로또번호가_중복이면_오류() {
        assertThatThrownBy(() -> new UserLotto(testLotto, testBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_DUPLICATED.getMessage());
    }
}
