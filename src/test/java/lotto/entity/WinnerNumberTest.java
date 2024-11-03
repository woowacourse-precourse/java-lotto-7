package lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.Test;

class WinnerNumberTest {

    @Test
    void 모든_검증에_통과하여_정상적으로_생성된다() {
        // given
        List<Integer> winnerNumbers = List.of(1, 5, 2, 25, 39, 12);

        // when
        WinnerNumber winnerNumber = new WinnerNumber(winnerNumbers);

        // then
        assertThat(winnerNumber.numbers()).isEqualTo(winnerNumbers);
    }

    @Test
    void validateSize_로또_개수가_맞지_않아_검증에_실패한다() {
        // given
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5);

        // when

        // then
        assertThatThrownBy(() -> new WinnerNumber(winnerNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.LOTTO_INVALID_SIZE);
    }

    @Test
    void validateInRange_당첨_번호의_범위가_맞지_않아_검증에_실패한다() {
        // given
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 46);

        // when

        // then
        assertThatThrownBy(() -> new WinnerNumber(winnerNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE);
    }

    @Test
    void validateInRange_당첨_번호의_범위가_맞지_않아_검증에_실패한다2() {
        // given
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 0);

        // when

        // then
        assertThatThrownBy(() -> new WinnerNumber(winnerNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE);
    }

    @Test
    void validateDuplicate_중복된_번호가_있어_검증에_실패한다() {
        // given
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when

        // then
        assertThatThrownBy(() -> new WinnerNumber(winnerNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.LOTTO_NUMBER_DUPLICATED);
    }
}