package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void validateBonusNumberDuplication() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다")
    @Test
    void validateBonusNumberRange() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 등수를 올바르게 계산한다")
    @Test
    void calculateLottoRank() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 6))))  // 6개 일치
                .isEqualTo(Rank.FIRST);
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 7))))  // 5개 + 보너스
                .isEqualTo(Rank.SECOND);
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 8))))  // 5개
                .isEqualTo(Rank.THIRD);
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 7, 8))))  // 4개
                .isEqualTo(Rank.FOURTH);
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 7, 8, 9))))  // 3개
                .isEqualTo(Rank.FIFTH);
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 7, 8, 9, 10)))) // 2개
                .isEqualTo(Rank.NONE);
    }
}