package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static lotto.LottoView.getWinningNumbers;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoViewTest {
    @DisplayName("당첨 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 당첨_번호가_범위를_벗어나면_예외가_발생한다() {
        // given
        String input = "0,2,3,4,5,6";

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        assertThatThrownBy(() -> getWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(originalIn);
    }
}
