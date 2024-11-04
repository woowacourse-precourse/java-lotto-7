package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    @DisplayName("구입 금액이 유효하지 않으면 예외 발생")
    void 구입_금액_유효성_검증() {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");

        assertThatThrownBy(() -> Validator.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아니거나, 중복되거나, 범위를 벗어나면 예외 발생")
    void 당첨_번호_유효성_검증() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        List<Integer> outOfRangeNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        List<Integer> lessThanSixNumbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> Validator.validateWinningNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");

        assertThatThrownBy(() -> Validator.validateWinningNumbers(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");

        assertThatThrownBy(() -> Validator.validateWinningNumbers(lessThanSixNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개의 숫자로 입력해야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외 발생")
    void 보너스_번호_범위_유효성_검증() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> Validator.validateBonusNumber(0, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");

        assertThatThrownBy(() -> Validator.validateBonusNumber(46, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    void 보너스_번호_중복_유효성_검증() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 5;

        assertThatThrownBy(() -> Validator.validateBonusNumber(duplicateBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 500, 1500})
    @DisplayName("구입 금액이 1,000원 단위가 아니거나 양수가 아니면 예외가 발생한다")
    void 구입_금액이_1_000원_단위가_아니거나_양수가_아니면_예외가_발생한다(int invalidAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
    }
}