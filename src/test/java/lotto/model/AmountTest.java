package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {
    @Test
    @DisplayName("로또_구입금액의_단위가_1000이_아니라면_예외가_발생한다")
    void validateUnit() {
        assertThatThrownBy(() -> new Amount(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구매는 1000원 단위로 가능합니다.");
    }

    @Test
    @DisplayName("로또_구입금액의_타입이_숫자가_아니라면_예외가_발생한다")
    void validateType() {
        assertThatThrownBy(() -> Amount.of("2000a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액을 숫자로 입력해주세요.");
    }

}
