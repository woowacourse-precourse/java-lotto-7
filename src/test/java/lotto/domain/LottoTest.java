package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.view.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개여야 한다.")
    @Test
    void 로또_번호의_개수가_6개여야_한다() {
        // given & when
        Lotto lotto = new Lotto();

        // then
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertRandomUniqueNumbersInRangeTest(() ->
                        assertThatThrownBy(Lotto::new)
                                .isInstanceOf(IllegalArgumentException.class),
                List.of(1, 2, 3, 4, 5, 5)
        );
    }

    @DisplayName("로또 번호가 올바른 범위에 없으면 예외가 발생한다.")
    @Test
    void 로또_번호가_올바른_범위에_없으면_예외가_발생한다() {
        assertRandomUniqueNumbersInRangeTest(() ->
                        assertThatThrownBy(Lotto::new)
                                .isInstanceOf(IllegalArgumentException.class),
                List.of(46, 1, 2, 3, 4, 5)
        );
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복이면_예외가_발생한다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
                    // given
                    Lotto winningNumbers = new Lotto();

                    // when
                    int bonusNumber = 1;

                    // then
                    assertThatThrownBy(() -> winningNumbers.validateNumber(bonusNumber))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }
}
