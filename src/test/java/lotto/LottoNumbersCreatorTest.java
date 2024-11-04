package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void 입력값으로_숫자_리스트를_만든다() {
        String input = "1,3,4,6,2,8";
        assertThat(LottoNumbersCreator.createNumberListByInput(input))
                .isEqualTo(List.of(1,3,4,6,2,8));
    }

    @Test
    void 입력값으로_당첨_복권_숫자_리스트를_만든다() {
        String input = "1,34,6,2,8";
        assertThat(LottoNumbersCreator.createWinningNumbers(input))
                .isEqualTo(List.of(1,34,6,2,8));

        String input1 = ",1,3,4,6,2,8";
        assertThatThrownBy(() -> LottoNumbersCreator.createWinningNumbers(input1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
