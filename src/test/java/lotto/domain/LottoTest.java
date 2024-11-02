package lotto.domain;

import static lotto.domain.constant.LottoConstraint.FIXED_LOTTO_SIZE;
import static lotto.domain.constant.LottoConstraint.MAXIMUM_NUMBER_VALUE;
import static lotto.domain.constant.LottoConstraint.MINIMUM_NUMBER_VALUE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 요구사항_라이브러리를_활용하면_로또객체가_정상적으로_생성될수있다() {
        // given
        var expectedUniqueNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER_VALUE,
                MAXIMUM_NUMBER_VALUE,
                FIXED_LOTTO_SIZE);
        // when
        Lotto lotto = new Lotto(expectedUniqueNumbers);
        // then
        Assertions.assertThat(lotto).isNotNull();
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        /// given
        // when
        // then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        /// given
        // when
        // then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
