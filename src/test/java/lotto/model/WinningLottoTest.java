package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("당첨 로또 번호와 보너스 번호가 겹치면 예외 발생")
    @Test
    void throwExceptionIfWinningLottoNumbersAndBonusNumberAreDuplicated() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(lotto, 1)).isInstanceOf(IllegalArgumentException.class);
    }
}