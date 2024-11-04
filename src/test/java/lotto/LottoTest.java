package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("숫자가 아닌 입력이 있으면 예외가 발생한다")
    @Test
    void validateNumericInput_WhenNotNumeric() {
        assertThatThrownBy(() -> LottoValidator.validateNumericInput("abc123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 입력값이면 예외가 발생한다")
    @Test
    void validateNumericInput_WhenEmpty() {
        assertThatThrownBy(() -> LottoValidator.validateNumericInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 미만이면 예외가 발생한다")
    @Test
    void validatePurchaseAmount_WhenLessThanMinimum() {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 단위가 아니면 예외가 발생한다")
    @Test
    void validatePurchaseAmount_WhenNotThousandUnit() {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위를 벗어나면 예외가 발생한다")
    @Test
    void validateLottoNumberRange_WhenOutOfRange() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 입력값이 음수이면 예외가 발생한다")
    @Test
    void validatePurchaseInput_WhenNegative() {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseInput("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void validateWinningNumbers_WhenNotSixNumbers() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void validateWinningNumbers_WhenDuplicate() {
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void validateBonusNumber_WhenDuplicateWithWinning() {
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void validateLottoNumbers_WhenNotSixNumbers() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 구분된 입력이 6개가 아니면 예외가 발생한다")
    @Test
    void validateCommaSeparatedNumbers_WhenNotSixNumbers() {
        assertThatThrownBy(() -> LottoValidator.validateCommaSeparatedNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 구분된 입력에 숫자가 아닌 값이 있으면 예외가 발생한다")
    @Test
    void validateCommaSeparatedNumbers_WhenNotNumeric() {
        assertThatThrownBy(() -> LottoValidator.validateCommaSeparatedNumbers("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 구분된 입력에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void validateCommaSeparatedNumbers_WhenDuplicate() {
        assertThatThrownBy(() -> LottoValidator.validateCommaSeparatedNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 오름차순으로 정렬되어 있어야 한다")
    void lottoNumbersShouldBeSorted() {
        List<Integer> numbers = List.of(45, 23, 1, 14, 32, 8);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers())
                .isSorted()
                .containsExactly(1, 8, 14, 23, 32, 45);
    }

    @Test
    @DisplayName("1부터 45 사이의 숫자로 로또를 생성할 수 있다")
    void createValidLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> new Lotto(numbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호가 null이면 예외가 발생한다")
    void validateNull() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100, -1})
    @DisplayName("로또 번호가 1-45 범위를 벗어나면 예외가 발생한다")
    void validateNumberRange(int invalidNumber) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        numbers.add(invalidNumber);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수익률 계산이 정확해야 한다")
    void calculateProfitRate() {
        int purchaseAmount = 1000;
        int winningAmount = 5000;  // 5등 당첨

        double expectedRate = ((double) winningAmount / purchaseAmount) * 100;
        assertThat(expectedRate).isEqualTo(500.0);
    }


    @Test
    @DisplayName("구매 금액이 0이면 예외가 발생한다")
    void validateZeroPurchaseAmount() {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000.5", "abc", "1000원"})
    @DisplayName("구매 금액이 정수가 아니면 예외가 발생한다")
    void validateNonIntegerPurchaseAmount(String input) {
        assertThatThrownBy(() -> LottoValidator.validatePurchaseInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void validateDuplicateBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 형식이 잘못되면 예외가 발생한다")
    void validateWinningNumberFormat() {
        assertThatThrownBy(() -> LottoValidator.validateCommaSeparatedNumbers("1,2,3,4,5,"))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
