package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.lottoapp.model.value.BonusNumber;
import lotto.lottoapp.model.value.LottoNumbers;
import lotto.lottoapp.model.value.WinningLottoNumbers;
import org.junit.jupiter.api.Test;

class WinningLottoNumbersTest {

    public static final Class<IllegalArgumentException> COMMON_EXCEPTION = IllegalArgumentException.class;

    @Test
    void 당첨번호는_로또숫자들과_보너스숫자를_가진다() {
        LottoNumbers lottoNumbers = LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        assertThatCode(() -> new WinningLottoNumbers(lottoNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨번호의_로또숫자들과_보너스로또숫자가_중복되면_예외발생() {
        LottoNumbers lottoNumbers = LottoNumbers.of(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(1);

        assertThatThrownBy(() -> new WinningLottoNumbers(lottoNumbers, bonusNumber))
                .isInstanceOf(COMMON_EXCEPTION);
    }

}