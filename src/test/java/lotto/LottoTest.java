package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("로또 번호와 일치하는 숫자의 갯수를 리턴한다")
    @Test
    void 로또_번호와_일치하는_숫자의_갯수를_리턴한다() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winNumber = List.of(1,2,12,13,14,15);

        int matchNumber = lotto.calculateMatchCount(winNumber);

        Assertions.assertEquals(2, matchNumber);
    }

    @DisplayName("로또 번호와 일치하는 보너스 번호가 있는지 확인한다")
    @Test
    void 로또_번호와_일치하는_보너스_번호가_있는지_확인한다() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        boolean isMatched = lotto.findMatchBonusNumber(1);

        Assertions.assertEquals(true, isMatched);
    }

}
