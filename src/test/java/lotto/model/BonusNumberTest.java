package lotto.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.exception.ErrorMessages.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    private static WinningNumbers winningNumbers;

    @BeforeAll
    static void setUp() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winningNumbers = WinningNumbers.from(numbers);
    }

    @Test
    @DisplayName("보너스번호가 빈 문자열이면 예외가 발생한다 - 빈문자열일 경우")
    void 보너스번호가_빈_문자열이면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_EMPTY_ERROR);
    }

    @Test
    @DisplayName("보너스번호가 빈 문자열이면 예외가 발생한다 - 공백일 경우")
    void 보너스번호가_빈_문자열이면_예외가_발생한다2() {
        assertThatThrownBy(() -> new BonusNumber("     ", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_EMPTY_ERROR);
    }

    @Test
    @DisplayName("보너스번호가 1 이상 45 이하가 아니면 예외가 발생한다 - 범위에 해당하지 않는 숫자일 경우")
    void 보너스번호가_1_이상_45_이하가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("46", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE_ERROR);
    }

    @Test
    @DisplayName("보너스번호가 1 이상 45 이하가 아니면 예외가 발생한다 - 문자일 경우")
    void 보너스번호가_1_이상_45_이하가_아니면_예외가_발생한다2() {
        assertThatThrownBy(() -> new BonusNumber("jinyoung", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE_ERROR);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        // 당첨 번호는 1, 2, 3, 4, 5, 6이다.
        assertThatThrownBy(() -> new BonusNumber("6", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_BONUS_NUMBER_ERROR);
    }
}