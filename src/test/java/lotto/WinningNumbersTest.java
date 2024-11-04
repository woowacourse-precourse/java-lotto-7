package lotto;

import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.ErrorMessage.INVALID_WINNING_NUMBERS_COUNT;
import static lotto.ErrorMessage.NOT_UNIQUE_WINNING_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {

    @DisplayName("WinningNumbers는_번호가_중복되면_예외를_발생한다")
    @Test
    public void should_ThrowException_WhenNumberIsNotUnique() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
        //when
        //then
        assertThatThrownBy(() -> WinningNumbers.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_UNIQUE_WINNING_NUMBER.getMessage());
    }

    @DisplayName("WinningNumbers는_번호의_개수가_틀리면_예외를_발생한다")
    @Test
    public void should_ThrowException_WhenNumberCountIsInvalid() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        //when
        //then
        assertThatThrownBy(() -> WinningNumbers.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_WINNING_NUMBERS_COUNT.getMessage());
    }

    @DisplayName("WinningNumbers는_번호가_특정범위를_벗어나면_예외를_발생한다")
    @Test
    public void should_ThrowException_WhenNumberRangeIsInvalid() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 48);
        //when
        //then
        assertThatThrownBy(() -> WinningNumbers.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @DisplayName("WinningNumbers는_번호를_포함하고_있는_지_여부를_반환할_수_있다")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:true", "6:true", "7:false"}, delimiter = ':')
    @ParameterizedTest
    public void contains(int input, boolean expected) {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = WinningNumbers.of(numbers);

        //when
        //then
        assertThat(winningNumbers.contains(input)).isEqualTo(expected);
    }
}