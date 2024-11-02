package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("로또 3개 일치시 5등")
    @Test
    void matchThreeNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 15, 16, 17));
        int bonusNumber = 10;

        assertThat(lotto.countMatchNumber(winningNumber, bonusNumber)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또 4개 일치시 4등")
    @Test
    void matchFourNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 16, 17));
        int bonusNumber = 10;

        assertThat(lotto.countMatchNumber(winningNumber, bonusNumber)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("로또 5개 일치시 3등")
    @Test
    void matchFiveNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 17));
        int bonusNumber = 10;

        assertThat(lotto.countMatchNumber(winningNumber, bonusNumber)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("로또 5개 및 보너스 번호 일치시 2등")
    @Test
    void matchFiveAndBonusNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 17));
        int bonusNumber = 6;

        assertThat(lotto.countMatchNumber(winningNumber, bonusNumber)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("로또 6개 일치시 1등")
    @Test
    void matchSixNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;

        assertThat(lotto.countMatchNumber(winningNumber, bonusNumber)).isEqualTo(Rank.FIRST);
    }
}
