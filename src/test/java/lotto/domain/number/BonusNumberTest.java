package lotto.domain.number;

import lotto.global.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다")
    @Test
    void should_ThrowException_When_BonusNumberDuplicatedWithWinningNumbers() {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from("1,2,3,4,5,6");

        // when & then
        assertThatThrownBy(() -> BonusNumber.from(1, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호는 1부터 45 사이의 숫자여야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 100})
    void should_ThrowException_When_BonusNumberOutOfRange(int number) {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from("1,2,3,4,5,6");

        // when & then
        assertThatThrownBy(() -> BonusNumber.from(number, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
    }
}