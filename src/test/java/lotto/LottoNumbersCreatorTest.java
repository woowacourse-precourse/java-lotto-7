package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoNumbersCreatorTest {
    @Test
    void 콤마로_시작하거나_끝나면_에러가_난다() {
        String input1 = ",1,2,4,3";
        assertThatThrownBy(() -> LottoNumbersCreator.validateNotStartEndWithComma(input1))
                .isExactlyInstanceOf(IllegalArgumentException.class);

        String input2 = "1,2,4,3,";
        assertThatThrownBy(() -> LottoNumbersCreator.validateNotStartEndWithComma(input2))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
