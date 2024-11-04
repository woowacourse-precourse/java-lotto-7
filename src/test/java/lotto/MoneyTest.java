package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    void 금액이_음수면_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1000));
    }
}
