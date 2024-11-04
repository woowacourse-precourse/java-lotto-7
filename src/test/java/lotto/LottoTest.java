package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void getMatchCount_test() {
        // given
        Lotto lotto1 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lotto lotto2 = new Lotto(List.of(11, 12, 13, 14, 15, 6));
        Lotto lotto3 = new Lotto(List.of(11, 12, 13, 14, 5, 6));
        Lotto lotto4 = new Lotto(List.of(11, 12, 13, 4, 5, 6));
        Lotto lotto5 = new Lotto(List.of(11, 12, 3, 4, 5, 6));
        Lotto lotto6 = new Lotto(List.of(11, 2, 3, 4, 5, 6));
        Lotto lotto7 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lotto1.getMatchCount(winningNumbers)).isEqualTo(0);
        assertThat(lotto2.getMatchCount(winningNumbers)).isEqualTo(1);
        assertThat(lotto3.getMatchCount(winningNumbers)).isEqualTo(2);
        assertThat(lotto4.getMatchCount(winningNumbers)).isEqualTo(3);
        assertThat(lotto5.getMatchCount(winningNumbers)).isEqualTo(4);
        assertThat(lotto6.getMatchCount(winningNumbers)).isEqualTo(5);
        assertThat(lotto7.getMatchCount(winningNumbers)).isEqualTo(6);
    }

    @Test
    void hasBonusNumber_test() {
        // given
        Lotto lotto1 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 13;

        // then
        assertThat(lotto1.hasBonusNumber(bonusNumber)).isEqualTo(true);
        assertThat(lotto2.hasBonusNumber(bonusNumber)).isEqualTo(false);
    }

    @Test
    void toString_test() {
        // given
        Lotto lotto1 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lotto1.toString()).isEqualTo("[11, 12, 13, 14, 15, 16]");
        assertThat(lotto2.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
