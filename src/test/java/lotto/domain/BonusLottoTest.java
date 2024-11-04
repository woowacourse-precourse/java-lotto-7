package lotto.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusLottoTest {

    @ParameterizedTest
    @ValueSource(ints = {-10, 0, 46, 99})
    void 보너스_번호의_범위가_로또_범위를_벗어나면_예외가_발생한다(int bonusNumber) {
        assertThatThrownBy(() -> new BonusLotto(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}