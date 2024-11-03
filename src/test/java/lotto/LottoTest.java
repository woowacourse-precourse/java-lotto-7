package lotto;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

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
    @DisplayName("로또번호_6개_일치여부를_확인한다")
    public void 로또번호_6개_일치여부를_확인한다() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lastWeekLotto = Arrays.asList(6, 5, 4, 3, 2, 1);
        int result = LottoGame.matchNum(lotto, lastWeekLotto);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("로또번호_3개_일치여부를_확인한다")
    public void 로또번호_3개_일치여부를_확인한다() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lastWeekLotto = Arrays.asList(10, 9, 8, 3, 2, 1);
        int result = LottoGame.matchNum(lotto, lastWeekLotto);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("로또번호_0개_일치여부를_확인한다")
    public void 로또번호_0개_일치여부를_확인한다() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lastWeekLotto = Arrays.asList(7, 8, 9, 10, 11, 12);
        int result = LottoGame.matchNum(lotto, lastWeekLotto);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("보너스번호_일치여부를_확인한다")
    public void 보너스번호_일치여부를_확인한다() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusBall = 7;
        int result = LottoGame.matchBonus(lotto, bonusBall);
        assertEquals(1, result); // 보너스볼이 일치함
    }

    @Test
    @DisplayName("보너스번호_불일치여부를_확인한다")
    public void 보너스번호_불일치여부를_확인한다() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusBall = 8;
        int result = LottoGame.matchBonus(lotto, bonusBall);
        assertEquals(0, result); // 보너스볼이 일치하지 않음
    }

}
