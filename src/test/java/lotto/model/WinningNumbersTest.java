package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("6개의 고유 번호가 범위 내에 있으면 WinningNumbers 객체가 정상적으로 생성된다.")
    @Test
    void createWinningNumbersSuccessfully() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        WinningNumbers winningNumbers = WinningNumbers.of(validNumbers);

        // then
        assertThat(winningNumbers.winningNumbers()).isEqualTo(validNumbers);
    }

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenWinningNumbersCountIsInvalid() {
        // given
        List<Integer> invalidCountNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> WinningNumbers.of(invalidCountNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_FORMAT.message());
    }

    @DisplayName("당첨 번호에 중복된 숫자가 포함되어 있으면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenWinningNumbersContainDuplicates() {
        // given
        List<Integer> duplicateNumbers = List.of(1, 2, 3, 3, 5, 6);

        // when & then
        assertThatThrownBy(() -> WinningNumbers.of(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_WINNING_NUMBERS.message());
    }

    @DisplayName("당첨 번호가 범위(1-45) 밖에 있는 숫자를 포함하면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenWinningNumbersAreOutOfRange() {
        // given
        List<Integer> outOfRangeNumbers = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> WinningNumbers.of(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUMBER_RANGE.message());
    }

    @DisplayName("당첨 번호를 불변 리스트로 반환한다.")
    @Test
    void returnImmutableWinningNumbers() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningNumbers winningNumbers = WinningNumbers.of(validNumbers);

        // when
        List<Integer> retrievedNumbers = winningNumbers.winningNumbers();

        // then
        assertThatThrownBy(() -> retrievedNumbers.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
