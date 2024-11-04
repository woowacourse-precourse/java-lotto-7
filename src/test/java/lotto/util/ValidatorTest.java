package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 로또_번호의_개수가_6개가_아니면_예외발생() {
        assertThatThrownBy(() -> Validator.validateLottoNumberCount(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.ERROR_INVALID_LOTTO_NUMBER_COUNT);
    }

    @Test
    void 로또_번호가_1보다_작거나_45보다_크면_예외발생() {
        assertThatThrownBy(() -> Validator.validateLottoNumberRange(List.of(0, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.ERROR_OUT_OF_RANGE_NUMBER);
    }

    @Test
    void 중복된_로또_번호가_있으면_예외발생() {
        assertThatThrownBy(() -> Validator.validateLottoNumberDuplication(List.of(1, 2, 2, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.ERROR_DUPLICATE_NUMBER);
    }

    @Test
    void 구입금액이_1000원_단위가_아니면_예외발생() {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.ERROR_INVALID_TICKET_COUNT);
    }

    @Test
    void 숫자형식이_아닐경우_예외발생() {
        assertThatThrownBy(() -> Validator.validateAndParseNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.ERROR_INVALID_MONEY_FORMAT);
    }

    @Test
    void 보너스번호가_당첨번호와_중복이면_예외발생() {
        assertThatThrownBy(() -> Validator.validateBonusNumberDuplication(List.of(1, 2, 3, 4, 5), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Config.ERROR_BONUS_NUMBER_DUPLICATE);
    }
}
