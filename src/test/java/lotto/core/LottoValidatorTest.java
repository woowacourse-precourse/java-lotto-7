package lotto.core;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import constants.ErrorMessage;
import java.util.List;
import lotto.core.Lotto;
import lotto.core.LottoNumber;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {

    @Test
    void 로또_번호에_숫자가_6개가_아닌_경우_예외() {
        assertThatThrownBy(() -> new Lotto(
                List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                        LottoNumber.from(5), LottoNumber.from(6), LottoNumber.from(7))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_MATCH_LOTTO_SIZE);
    }

    @Test
    void 로또_번호에_숫자가_중복된_경우_예외() {
        assertThatThrownBy(() -> new Lotto(
                List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                        LottoNumber.from(5), LottoNumber.from(5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EXISTS_DUPLICATE_NUMBER);
    }
}
