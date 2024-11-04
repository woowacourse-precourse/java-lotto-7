package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    void 구입_금액에_문자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Money.from("우테코"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
