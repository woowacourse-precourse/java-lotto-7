package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {
    @Test
    @DisplayName("로또_구입금액의_단위가_1000이_아니라면_예외가_발생한다")
    void validateUnit() {
        assertThatThrownBy(() -> new Amount(2500))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
}
