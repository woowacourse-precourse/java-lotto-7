package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 정상_케이스() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertNotNull(lotto);
        Assertions.assertEquals(6, lotto.getNumbers().size());
        Assertions.assertEquals("[1, 2, 3, 4, 5, 6]", lotto.getFormattedNumbers());
    }

    @Test
    @DisplayName("로또 번호의 갯수가 6개가 넘어가면 예외가 발생한다.")
    void 로또_번호의_갯수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1과 45 사이 외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_1과_45_사이_외의_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 정렬된 상태로 저장되어야 한다.")
    void 로또_번호는_정렬된_상태로_저장되어야_한다() {
        Lotto lotto = new Lotto(List.of(19, 41, 3, 45, 10, 8));
        Assertions.assertEquals("[3, 8, 10, 19, 41, 45]", lotto.getFormattedNumbers());
    }


}
