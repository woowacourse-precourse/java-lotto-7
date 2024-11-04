package lotto.model.win;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.message.LottoErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 세트 객체 테스트")
class LottoWinningSetTest {

    @DisplayName("당첨 번호와 보너스 번호가 올바른 경우 예외가 발생하지 않는다.")
    @Test
    void shouldNotThrowException_WhenWinningNumbersAndBonusNumberIsValid() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        assertDoesNotThrow(() -> new LottoWinningSet(winningNumbers, bonusNumber));
    }

    @DisplayName("당첨 번호와 보너스 번호에 중복이 존재하는 경우 예외가 발생한다.")
    @Test
    void shouldThrowException_WhenWinningNumbersAndBonusNumberDuplicate() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(1);

        assertThatThrownBy(() -> new LottoWinningSet(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.WINNING_SET_NUMBERS_DUPLICATE.get());
    }
}
