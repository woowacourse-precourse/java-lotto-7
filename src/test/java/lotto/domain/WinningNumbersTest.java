package lotto.domain;

import lotto.error.LottoErrorMessage;
import lotto.error.NumberErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    @Test
    void 당첨번호_갯수는_6개여야_한다() {
        //given
        List<String> numbers = List.of("1", "2", "3");

        //when && then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoErrorMessage.UNMATCHED_SIZE.getMessage());
    }

    @Test
    void 당첨번호는_모두_숫자여야_한다() {
        //given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "a");

        //when && then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.IS_NOT_NUMBER.getMessage());
    }

    @Test
    void 당첨번호는_1부터_45_사이여야_한다() {
        //given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "46");

        //when && then
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NumberErrorMessage.NOT_ALLOWED_NUMBER.getMessage());
    }

    @Test
    void 정상_테스트() {
        //given
        List<String> numbers = List.of("1", "2", "3", "4", "5", "45");

        //when && then
        assertThatCode(() -> new WinningNumbers(numbers))
                .doesNotThrowAnyException();
    }
}