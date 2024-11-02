package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @DisplayName("WinningNumbers를 생성할 수 있다.")
    @Test
    void createWinningNumbers() {
        //given
        Lotto winningLottoNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        //when
        WinningNumbers winningNumbers = WinningNumbers.of(winningLottoNumbers, bonusNumber);

        //then
        assertThat(winningNumbers).isEqualTo(WinningNumbers.of(winningLottoNumbers, bonusNumber));
    }

    @DisplayName("당첨 로또 번호와 보너스 번호가 중복된다면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void duplicateWinningNumbers(int bonusNumber) {
        //given
        Lotto winningLottoNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        //when //then
        assertThatThrownBy(() -> WinningNumbers.of(winningLottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATE_WINNING_NUMBERS.getErrorMessage());
    }

    @DisplayName("당첨 로또 번호와 보너스 번호가 중복되지 않는다면 예외를 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"7", "8", "9", "10", "11", "12"})
    void nonDuplicateWinningNumbers(int bonusNumber) {
        //given
        Lotto winningLottoNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        //when //then
        assertThatCode(() -> WinningNumbers.of(winningLottoNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }
}
