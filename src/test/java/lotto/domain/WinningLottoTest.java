package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외 발생")
    void 당첨번호_보너스_번호_중복_시_예외_발생 () {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThatThrownBy(() ->
                new WinningLotto(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호와 보너스 번호가 중복됩니다");
    }
}
