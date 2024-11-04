package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoValidatorTest {

    @Test
    void 당첨번호가_6개가_아닌_경우_예외() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateWinningNumbers(numbers));
        assertThat(exception.getMessage()).contains("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 당첨번호에_중복이_있으면_예외() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateWinningNumbers(numbers));
        assertThat(exception.getMessage()).contains("[ERROR] 로또 번호에는 중복이 없어야 합니다.");
    }

    @Test
    void 당첨번호가_범위를_벗어나면_예외() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateWinningNumbers(numbers));
        assertThat(exception.getMessage()).contains("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스_번호가_범위를_벗어나면_예외() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateBonusNumber(bonusNumber, winningNumbers));
        assertThat(exception.getMessage()).contains("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스_번호가_당첨번호와_중복이_있으면_예외() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 5;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validateBonusNumber(bonusNumber, winningNumbers));
        assertThat(exception.getMessage()).contains("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
