package lotto.model;

import static lotto.common.exception.ErrorMessage.WINNING_NUMBERS_COUNT_ERROR;
import static lotto.common.exception.ErrorMessage.WINNING_NUMBERS_DUPLICATION_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 당첨_번호는_중복되지_않는_6개의_번호로_구성된다() {
        // given
        List<LottoNumber> numbers = List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        );

        // when
        WinningNumbers winningNumbers = WinningNumbers.from(numbers);

        // then
        assertEquals(winningNumbers.numbers(), numbers);
    }

    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        // given
        List<LottoNumber> numbers = List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
                LottoNumber.from(7)
        );

        // when & then
        assertThatThrownBy(() -> WinningNumbers.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_COUNT_ERROR.message());
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<LottoNumber> numbers = List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(5)
        );

        // when & then
        assertThatThrownBy(() -> WinningNumbers.from(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBERS_DUPLICATION_ERROR.message());
    }
}
