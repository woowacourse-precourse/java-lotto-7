package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    private static final LottoConfig CONFIG = LottoConfig.WOOWA_CONFIG;
    private static final String ERROR_PREFIX = "[ERROR]";

    @Test
    void 로또_당첨_번호의_수가_로또_번호의_수와_다르다면_예외가_발생한다(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> WinningLotto.ofNumbersAndConfig(numbers, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBERS_COUNT.getMessage())
                .hasMessageStartingWith(ERROR_PREFIX);
    }

    @Test
    void 로또_당첨_번호들_중_로또_번호의_숫자_범위_초과이면_예외가_발생한다(){
        List<Integer> numbers = List.of(1,2,3,4,5,46);

        assertThatThrownBy(() -> WinningLotto.ofNumbersAndConfig(numbers, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBER_MORE_THAN_MAX.getMessage())
                .hasMessageStartingWith(ERROR_PREFIX);
    }

    @Test
    void 로또_당첨_번호들_중_로또_번호의_숫자_범위_미만이면_예외가_발생한다(){
        List<Integer> numbers = List.of(0,1,2,3,4,5);

        assertThatThrownBy(() -> WinningLotto.ofNumbersAndConfig(numbers, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBER_LESS_THAN_MIN.getMessage())
                .hasMessageStartingWith(ERROR_PREFIX);
    }

    @Test
    void 로또_당첨_번호들_중_중복된_숫자가_존재한다면_예외가_발생한다(){
        List<Integer> numbers = List.of(1,2,3,4,5,5);

        assertThatThrownBy(() -> WinningLotto.ofNumbersAndConfig(numbers, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBERS_DUPLICATION.getMessage())
                .hasMessageStartingWith(ERROR_PREFIX);
    }
}
