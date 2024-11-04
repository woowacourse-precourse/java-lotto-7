package lotto.domain;

import java.util.Arrays;
import lotto.global.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class
LottoTest {
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

    @DisplayName("checkWinningStatus_메서드_테스트_01")
    @Test
    void 기능_테스트() {
        //BonusNumber Hit!
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 6, 7));
        List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 10, 7);
        int bonusNumber = 7;

        //BonusNumber Dont Hit :(
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningLotto2 = Arrays.asList(1, 2, 3, 4, 5, 7, 9);
        int bonusNumber2 = 9;

        assertThat(lotto.checkWinningStatus(winningLotto, bonusNumber))
                .isEqualTo(LottoRank.SECOND);

        assertThat(lotto.checkWinningStatus(winningLotto, bonusNumber2))
                .isEqualTo(LottoRank.THIRD);
    }
}
