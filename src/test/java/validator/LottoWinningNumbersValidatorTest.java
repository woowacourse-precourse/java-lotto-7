package validator;

import java.util.List;
import lotto.validator.LottoWinningNumbersValidator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumbersValidatorTest {

    @Test
    public void 당첨번호_범위를_초과_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> LottoWinningNumbersValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");
    }

    @Test
    public void 당첨번호_개수_6_X_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3);

        assertThatThrownBy(() -> LottoWinningNumbersValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    public void 중복_당첨번호_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> LottoWinningNumbersValidator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");
    }

    @Test
    public void 정상입력_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoWinningNumbersValidator.validateWinningNumbers(winningNumbers);
    }
}