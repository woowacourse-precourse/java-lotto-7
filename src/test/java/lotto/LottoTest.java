package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testValidatePurchaseAmount_ValidAmount() {
        assertDoesNotThrow(() -> Lotto.validate_Purchase_amount(5000));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Lotto.validate_Purchase_amount(5500);
        });
        assertEquals("[ERROR] 로또 구입 금액은 천원 단위로 구매하여야 합니다.", exception.getMessage());
    }

    @Test
    void testValidateWinningNumbersCount_InvalidCount() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Lotto.validate_winningNumbers_count(5);
        });
        assertEquals("[ERROR] 당첨 번호는 6개 입력하여야 합니다.", exception.getMessage());
    }

    @Test
    void testValidateNoDuplicatesWinningNumbers_WithDuplicates() {
        int[] numbersWithDuplicates = {1, 2, 3, 4, 5, 5};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Lotto.validateNoDuplicates_winningNumbers(numbersWithDuplicates);
        });
        assertEquals("[ERROR] 중복된 숫자가 있습니다: 5", exception.getMessage());
    }

    @Test
    void testValidateNoDuplicatesBonusNumber_WithDuplicate() {
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        int bonusNumber = 1;

        assertThatThrownBy(() -> Lotto.validateNoDuplicates_bonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다: 1");
    }

    @Test
    void testValidateWinningNumbersLowerBound() {
        assertThatThrownBy(() -> Lotto.validate_winningNumbers_lower_45(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void testCountMatches() {
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int[] winningNumbers = {1, 2, 3, 7, 8, 9};

        int matchCount = Lotto.countMatches(myLotto, winningNumbers);

        assertEquals(3, matchCount);
    }

    @Test
    void testCalculateIncome() {
        int[] matchCountArray = {0, 0, 0, 1, 1, 1, 1, 0}; // 3개, 4개, 5개, 5개 + 보너스
        int totalIncome = Lotto.calculateIncome(matchCountArray);

        assertEquals(0 * 0 + 0 * 0 + 1 * 5000 + 1 * 50000 + 1 * 1500000 + 1 * 2000000000 + 0 * 30000000, totalIncome);
    }

    @Test
    void testCalculateROI() {
        int totalIncome = 1000000;
        int purchaseAmount = 10000;

        assertDoesNotThrow(() -> Lotto.calculateROI(totalIncome, purchaseAmount));
    }
}
