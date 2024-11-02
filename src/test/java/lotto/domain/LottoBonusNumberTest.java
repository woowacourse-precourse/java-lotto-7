package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.enums.LottoConfig;
import lotto.enums.LottoError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoBonusNumberTest {
    private static final LottoConfig CONFIG = LottoConfig.WOOWA_CONFIG;
    private static final String ERROR_PREFIX = "[ERROR]";
    private WinningLotto winningLotto;

    @BeforeEach
    void initWinningLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        this.winningLotto = WinningLotto.ofNumbersAndConfig(numbers, CONFIG);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 보너스_번호가_당첨_번호와_중복된다면_예외가_발생한다(int number) {
        assertThatThrownBy(() -> BonusNumber.ofNumberAndWinningLottoAndConfig(number, winningLotto, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_BONUS_NUMBER_DUPLICATION.getMessage())
                .hasMessageStartingWith(ERROR_PREFIX);
    }

    @Test
    void 보너스_번호가_로또_번호_미만이라면_예외가_발생한다() {
        int number = 0;

        assertThatThrownBy(() -> BonusNumber.ofNumberAndWinningLottoAndConfig(number, winningLotto, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBER_LESS_THAN_MIN.getMessage())
                .hasMessageStartingWith(ERROR_PREFIX);
    }

    @Test
    void 보너스_번호가_로또_번호_초과라면_예외가_발생한다() {
        int number = 46;

        assertThatThrownBy(() -> BonusNumber.ofNumberAndWinningLottoAndConfig(number, winningLotto, CONFIG))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.LOTTO_NUMBER_MORE_THAN_MAX.getMessage())
                .hasMessageStartingWith(ERROR_PREFIX);
    }

}
