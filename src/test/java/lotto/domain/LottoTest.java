package lotto.domain;

import lotto.domain.Lotto;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final LottoConfig LOTTO_CONFIG = LottoConfig.WOOWA_CONFIG;

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> Lotto.ofNumbersAndConfig(numbers, LOTTO_CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBERS_COUNT.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @Test
    void 로또_번호의_개수가_6개_미만이라면_예외가_발생한다(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> Lotto.ofNumbersAndConfig(numbers, LOTTO_CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBERS_COUNT.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> Lotto.ofNumbersAndConfig(numbers, LOTTO_CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBERS_DUPLICATION.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @Test
    void 로또_번호가_최소값_미만이라면_예외가_발생한다(){
        List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> Lotto.ofNumbersAndConfig(numbers, LOTTO_CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBER_LESS_THAN_MIN.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

    @Test
    void 로또_번호가_최대값_초과라면_예외가_발생한다(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> Lotto.ofNumbersAndConfig(numbers, LOTTO_CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBER_MORE_THAN_MAX.getMessage())
                .hasMessageMatching(LottoError.getErrorMessageFormat());
    }

}
