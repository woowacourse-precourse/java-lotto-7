package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ConvertInputTest {
    @Test
    void 구입금액에_문자가_포함되면_예외가_발생한다() {
        assertThatThrownBy(() -> ConvertInput.makeMoneyToInt("우테코프리코스"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
