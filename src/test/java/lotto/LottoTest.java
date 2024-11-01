package lotto;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.enums.Win;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_범위가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 999)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Nested
    class 로또_당첨_번호 {
        private Lotto lotto;

        @BeforeEach
        void setUp() {
            lotto = new Lotto(asList(1, 2, 3, 4, 5, 6));
        }

        @Test
        void 보너스_번호가_일치하면_2등() {
            List<Integer> winningNum = asList(1, 2, 3, 4, 5, 15);
            Integer bonusNum = 6;

            lotto.inputWin(winningNum, bonusNum);
            assertThat(lotto.getWin().getRank()).isEqualTo(Win.LOTTO_2ND.getRank());
        }

        @Test
        void 일치하는_번호가_없으면_null() {
            List<Integer> winningNum = asList(7, 8, 9, 10, 11, 12);
            Integer bonusNum = 13;

            lotto.inputWin(winningNum, bonusNum);
            assertThat(lotto.getWin()).isEqualTo(null);
        }
    }
}
