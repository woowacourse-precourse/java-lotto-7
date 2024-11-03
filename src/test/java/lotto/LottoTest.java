package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void 로또_당첨_번호_개수_확인_성공_테스트(){
        List<List<Integer>> numbers = List.of(
                List.of(1, 2, 3, 8, 9, 10),
                List.of(1, 2, 3, 4, 8, 9),
                List.of(1, 2, 3, 4, 5, 8),
                List.of(1, 2, 3, 4, 5, 6)
        );
        List<Integer> answer = List.of(3, 4, 5, 6);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        for (int i=0; i < numbers.size(); i++){
            Lotto lotto = new Lotto(numbers.get(i));
            assertThat(lotto.countMatchingWinningNumbers(winningNumbers)).isEqualTo(answer.get(i));
        }
    }

    @Test
    void 보너스_번호_일치_테스트(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertTrue(lotto.isMatchBonusNumber(3));
        Assertions.assertFalse(lotto.isMatchBonusNumber(7));
    }


}
