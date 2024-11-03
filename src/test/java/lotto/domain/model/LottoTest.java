package lotto.domain.model;

import static lotto.domain.constant.LottoConstraintProperties.FIXED_LOTTO_SIZE;
import static lotto.domain.constant.LottoConstraintProperties.MAXIMUM_NUMBER_VALUE;
import static lotto.domain.constant.LottoConstraintProperties.MINIMUM_NUMBER_VALUE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

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

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        /// given
        // when
        // then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 서로_다른_로또를_비교하여_맞는개수를_반환한다() {
        /// given
        int expectedMatchCount = 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto other = new Lotto(List.of(6, 7, 8, 9, 10, 11));
        // when
        int matchCount = lotto.match(other);
        // then
        Assertions.assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또에_해당번호가_포함되면_TRUE를_반환한다(int candidateNumber) {
        /// given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var candidate = new LottoNumber(candidateNumber);
        // when
        boolean hasElement = lotto.isContain(candidate);
        // then
        Assertions.assertThat(hasElement).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 10, 11, 12, 33, 45})
    void 로또에_해당번호가_포함되지_않으면_FALSE를_반환한다(int notContainNumber) {
        /// given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var candidate = new LottoNumber(notContainNumber);
        // when
        boolean hasElement = lotto.isContain(candidate);
        // then
        Assertions.assertThat(hasElement).isFalse();
    }


}
