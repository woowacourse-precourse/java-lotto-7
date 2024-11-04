package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void 로또_번호가_1부터_45사이가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 21, 23, 44, 55, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 로또번호_정렬_테스트() {
        Lotto lotto = new Lotto(List.of(15, 21, 3, 41, 5, 1));
        List<Integer> expectedNumbers = List.of(1, 3, 5, 15, 21, 41);

        assertEquals(expectedNumbers, lotto.getNumbers());
    }

    @Test
    void 당첨번호와_일치하는_로또번호_개수_테스트() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 일치
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12)); // 0개 일치
        Lotto lotto3 = new Lotto(List.of(2, 3, 6, 8, 9, 10)); // 3개 일치

        assertEquals(5, winningLotto.matchCount(lotto1));
        assertEquals(0, winningLotto.matchCount(lotto2));
        assertEquals(3, winningLotto.matchCount(lotto3));
    }





}



