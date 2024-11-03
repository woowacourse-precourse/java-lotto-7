package lotto.domain;

import lotto.util.ErrorCode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BallNumberTest {

    @Test
    void 정상입력() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when & then
        assertDoesNotThrow(() -> new BallNumber(winningNumbers, bonusNumber));
    }

    @Test
    void 당첨번호가_6개가_아님() {
        // given
        List<Integer> winningNumbers = List.of(1, 2);
        int bonusNumber = 7;

        // when & then
        assertThatThrownBy(() -> new BallNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_WINNING_NUMBER_COUNT.getMessage());
    }

    @Test
    void 당첨번호_중복_존재() {
        // given
        List<Integer> winningNumbers = List.of(1, 1, 1, 1, 1, 1);
        int bonusNumber = 7;

        // when & then
        assertThatThrownBy(() -> new BallNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATE_WINNING_NUMBER.getMessage());
    }

    @Test
    void 당첨번호_중_범위_밖_존재() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
        int bonusNumber = 7;

        // when & then
        assertThatThrownBy(() -> new BallNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_WINNING_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호와_당첨_번호_중복() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        // when & then
        assertThatThrownBy(() -> new BallNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호_범위_밖() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 0;

        // when & then
        assertThatThrownBy(() -> new BallNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_BONUS_NUMBER.getMessage());
    }

}