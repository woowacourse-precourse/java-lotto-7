package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 몇_개의_숫자가_일치하는지_알_수_있다() {
        // given
        Lotto lotto1 = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.of(List.of(1, 2, 3, 4, 11, 12));

        // when
        int sameNumberCount = lotto1.countSameNumbers(lotto2);

        // then
        assertThat(sameNumberCount).isEqualTo(4);
    }

    @Test
    void 로또번호에_특정_번호가_포함되어_있는지_확인할_수_있다() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber number = new LottoNumber(1);

        // when
        boolean contains = lotto.contains(number);

        // then
        assertThat(contains).isTrue();
    }

}
