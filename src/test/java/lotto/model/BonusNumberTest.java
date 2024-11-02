package lotto.model;

import lotto.exception.InvalidBonusNumberException;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @Test
    @DisplayName("유효한 보너스 번호가 주어졌을 때 BonusNumber 객체를 생성한다.")
    void createBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);

        assertThat(bonusNumber.get()).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어났을 때 예외가 발생한다.")
    void exceptionWhenBonusNumberHasInvalidRange() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new BonusNumber(46, winningNumbers))
                .isInstanceOf(InvalidBonusNumberException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호에 있는 숫자와 중복된 값일 때 예외가 발생한다.")
    void exceptionWhenBonusNumberHasDuplicateNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new BonusNumber(5, winningNumbers))
                .isInstanceOf(InvalidBonusNumberException.class)
                .hasMessageContaining(ErrorMessage.ALREADY_EXIST_IN_WINNING_NUMBERS.getMessage());
    }
}
