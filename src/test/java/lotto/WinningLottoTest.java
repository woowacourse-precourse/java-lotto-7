package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;
import lotto.exception.ErrorCode;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    void 보너스_번호_중복_검증() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @Test
    void 당첨_번호_일치_개수_계산() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        assertThat(winningLotto.matchNumbers(userLotto)).isEqualTo(3);
    }
}