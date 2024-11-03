package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        // given & when
        Lotto lotto = new Lotto();

        // then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(Lotto::new)
                                .isInstanceOf(IllegalArgumentException.class),
                1, 2, 3, 4, 5, 5
        );
    }
}
