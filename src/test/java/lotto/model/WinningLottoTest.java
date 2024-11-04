package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.lottoapp.model.WinningLotto;
import lotto.lottoapp.model.value.BonusNumber;
import lotto.lottoapp.model.value.LottoNumbers;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    public static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;
    public static final String ERROR_HEADER = "[ERROR]";

    @Test
    void 당첨번호는_로또숫자들과_보너스숫자를_가진다() {
        LottoNumbers lottoNumbers = LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        assertThatCode(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨번호의_로또숫자들과_보너스로또숫자가_중복되면_예외발생() {
        LottoNumbers lottoNumbers = LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(1);

        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(COMMON_EXCEPTION)
                .hasMessageContaining(ERROR_HEADER);
    }

}