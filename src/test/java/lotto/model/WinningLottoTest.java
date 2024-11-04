package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("입력받은 당첨번호 6개와 보너스번호 1개의 숫자가 중복되면 예외가 발생한다  ")
    @Test
    void occur() {
        assertThatThrownBy(() ->
                WinningLotto.createWinningLotto(List.of(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
