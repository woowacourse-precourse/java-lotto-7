package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    Lotto lotto;
    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

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
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있는지 검증 테스트")
    void 로또_번호에_보너스_번호가_포함되어_있는지_검증하는_테스트() {
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;
        assertEquals(lotto.isBonusMatch(lottos, bonusNumber), true);
    }

    @Test
    @DisplayName("로또 번호와 당첨번호, 보너스번호가 일치하는지 검증 테스트")
    void 로또_번호가_당첨번호나_보너스번호와_일치하는지_확인하는_테스트() {
        List<Integer> lottos = List.of(1, 2, 3, 4, 5, 9);
        List<Integer> luckyNumber = List.of(1, 2, 3, 4, 5, 7);
        int bonusNumber = 9;
        assertEquals(lotto.getMatchCount(lottos, luckyNumber, bonusNumber), 6);
    }
}
