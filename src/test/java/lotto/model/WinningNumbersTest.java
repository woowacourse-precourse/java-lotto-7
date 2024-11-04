package lotto.model;

import static org.assertj.core.api.Assertions.*;

import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    void 정상적인_당첨_보너스_번호가_들어오면_예외가_발생하지_않는다() {
        assertThatCode(() -> new WinningNumbers("1,2,3,4,5,6", "7")).doesNotThrowAnyException();
    }

    @Test
    void 비정성적인_당첨_보너스_번호가_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,99", "7"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
    }
}
