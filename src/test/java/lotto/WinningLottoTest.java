package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void validateDuplicateBonusNumber() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 중복되지 않은 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다")
    @Test
    void validateBonusNumberRange() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호와 보너스 번호로 당첨 등수를 정확히 계산한다")
    @Test
    void calculateLottoRank() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        // 1등 테스트
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(LottoRank.FIRST);

        // 2등 테스트
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(LottoRank.SECOND);

        // 3등 테스트
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 8)))).isEqualTo(LottoRank.THIRD);

        // 4등 테스트
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 8, 9)))).isEqualTo(LottoRank.FOURTH);

        // 5등 테스트
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 8, 9, 10)))).isEqualTo(LottoRank.FIFTH);

        // 미당첨 테스트
        assertThat(winningLotto.match(new Lotto(List.of(7, 8, 9, 10, 11, 12)))).isEqualTo(LottoRank.NONE);
    }
}