package lotto;

import lotto.domain.model.ErrorMessages;
import lotto.domain.model.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningNumbersTest {

    @Test
    void 당첨번호가_6개가_아니면_예외가_발생한다() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumbers(invalidNumbers, 7)
        );
        assert exception.getMessage().equals(ErrorMessages.INVALID_WINNING_NUMBER_COUNT.getMessage());
    }

    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumbers(winningNumbers, 5)
        );
        assert exception.getMessage().equals(ErrorMessages.DUPLICATE_WINNING_NUMBER.getMessage());
    }

    @Test
    void 번호가_범위_밖일_경우_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(0, 2, 3, 4, 5, 46); // 0과 46은 유효 범위를 벗어남
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumbers(winningNumbers, 7)
        );
        assert exception.getMessage().equals(ErrorMessages.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    void 입력값이_빈_값일_경우_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new WinningNumbers(Arrays.asList(), 7)
        );
        assert exception.getMessage().equals(ErrorMessages.EMPTY_INPUT.getMessage());
    }
}
