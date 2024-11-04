package lotto;

import lotto.enums.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoWithDuplicateBonus() {
        assertThatThrownBy(() ->
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("보너스 번호가 1-45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createWinningLottoWithInvalidBonus() {
        assertThatThrownBy(() ->
                new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45");
    }

    @DisplayName("당첨 등수를 정확히 반환한다.")
    @Test
    void matchLotto() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        assertThat(winningLotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isEqualTo(Prize.FIRST);
        assertThat(winningLotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))))
                .isEqualTo(Prize.SECOND);
        assertThat(winningLotto.match(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))))
                .isEqualTo(Prize.THIRD);
    }
}
