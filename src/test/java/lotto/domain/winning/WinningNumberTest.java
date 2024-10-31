package lotto.domain.winning;

import static lotto.exception.message.WinningNumberExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.exception.message.WinningNumberExceptionMessage.DUPLICATE_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("보너스 번호가 유효 범위(1-45)를 벗어나면 예외가 발생한다")
    void givenOutOfRangeBonusNumber_whenCreate_thenThrowsException(int bonusNumber) {
        // given
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void givenDuplicatedBonusNumber_whenCreate_thenThrowsException1() {
        // given
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        // when & then
        assertThatThrownBy(() -> new WinningNumber(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_BONUS_NUMBER.getMessage());
    }

}