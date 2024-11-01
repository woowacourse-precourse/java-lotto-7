package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class LottoPaperTest {

    @Test
    void 구매금액이_천원미만이면_예외를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoPaper(new Won(999)));
    }
}
