package lotto.model.lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoStoreValidatorTest {
    @Test
    void 유효한_구입금액일_경우_예외가_발생하지_않는다() {
        assertDoesNotThrow(() -> LottoStoreValidator.validate(1000L));
        assertDoesNotThrow(() -> LottoStoreValidator.validate(5000L));
        assertDoesNotThrow(() -> LottoStoreValidator.validate(10_000L));
    }

    @Test
    void 구입금액이_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoStoreValidator.validate(0L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");

        assertThatThrownBy(() -> LottoStoreValidator.validate(-1000L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");
    }

    @Test
    void 구입금액이_로또_단위의_배수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> LottoStoreValidator.validate(1500L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }
}