package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.WinningNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    private Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    @Nested
    @DisplayName("WinningNumbers 유효성 검사")
    class WinningNumbersValidationTests {

        @DisplayName("WinningNumbers에 null 보너스 번호를 설정할 수 없다.")
        @Test
        void winningNumbers_보너스번호_null() {
            assertThatThrownBy(() -> new WinningNumbers(createLotto(List.of(1, 2, 3, 4, 5, 6)), null))
                    .isInstanceOf(WinningNumberException.class)
                    .hasMessage(ErrorMessages.BONUS_NUMBER_NULL.getMessage());
        }

        @DisplayName("WinningNumbers에 null 메인 번호를 설정할 수 없다.")
        @Test
        void winningNumbers_메인번호_null() {
            assertThatThrownBy(() -> new WinningNumbers(null, 7))
                    .isInstanceOf(WinningNumberException.class)
                    .hasMessage(ErrorMessages.MAIN_NUMBERS_NULL.getMessage());
        }

        @DisplayName("WinningNumbers에 중복된 보너스 번호를 설정할 수 없다.")
        @Test
        void winningNumbers_중복된_보너스번호() {
            Lotto mainNumbers = createLotto(List.of(1, 2, 3, 4, 5, 6));
            assertThatThrownBy(() -> new WinningNumbers(mainNumbers, 1))
                    .isInstanceOf(WinningNumberException.class)
                    .hasMessage(ErrorMessages.BONUS_NUMBER_DUPLICATE.getMessage());
        }

        @DisplayName("WinningNumbers에 범위를 벗어난 보너스 번호를 설정할 수 없다.")
        @Test
        void winningNumbers_보너스번호_범위초과() {
            assertThatThrownBy(() -> new WinningNumbers(createLotto(List.of(1, 2, 3, 4, 5, 6)), 50))
                    .isInstanceOf(WinningNumberException.class)
                    .hasMessage(ErrorMessages.BONUS_NUMBER_RANGE.getMessage());
        }

        @DisplayName("WinningNumbers에 유효한 메인 번호와 보너스 번호를 설정할 수 있다.")
        @Test
        void winningNumbers_유효한_생성() {
            Lotto mainNumbers = createLotto(List.of(1, 2, 3, 4, 5, 6));
            WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, 7);

            assertThat(winningNumbers.mainNumbers()).isEqualTo(mainNumbers);
            assertThat(winningNumbers.bonusNumber()).isEqualTo(7);
        }
    }
}
