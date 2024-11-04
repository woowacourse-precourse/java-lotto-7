package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {

    @Nested
    @DisplayName("validatePurchaseAmount 메서드 테스트")
    class ValidatePurchaseAmountTest {

        @Test
        @DisplayName("구입 금액이 1000원 단위이고 0보다 클 때 성공")
        void validatePurchaseAmount_success() {
            String input = "5000";
            Validation.validatePurchaseAmount(input);
            assertThat(true).isTrue();
        }

        @Test
        @DisplayName("구입 금액이 0일 때 예외 발생")
        void validatePurchaseAmount_zero() {
            String input = "0";
            assertThatThrownBy(() -> Validation.validatePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }

        @Test
        @DisplayName("구입 금액이 음수일 때 예외 발생")
        void validatePurchaseAmount_negative() {
            String input = "-1000";
            assertThatThrownBy(() -> Validation.validatePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }

        @Test
        @DisplayName("구입 금액이 1000원 단위가 아닐 때 예외 발생")
        void validatePurchaseAmount_notMultipleOf1000() {
            String input = "1500";
            assertThatThrownBy(() -> Validation.validatePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }

        @Test
        @DisplayName("구입 금액이 숫자가 아닐 때 예외 발생")
        void validatePurchaseAmount_notNumber() {
            String input = "abc";
            assertThatThrownBy(() -> Validation.validatePurchaseAmount(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    @Nested
    @DisplayName("validateWinningNumbers 메서드 테스트")
    class ValidateWinningNumbersTest {

        @Test
        @DisplayName("당첨 번호가 6개이고 중복되지 않으며 1-45 범위일 때 성공")
        void validateWinningNumbers_success() {
            String input = "1,2,3,4,5,6";
            List<Integer> result = Validation.validateWinningNumbers(input);
            assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
        }

        @Test
        @DisplayName("당첨 번호가 6개가 아닐 때 예외 발생")
        void validateWinningNumbers_notSixNumbers() {
            String input = "1,2,3,4,5";
            assertThatThrownBy(() -> Validation.validateWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        @Test
        @DisplayName("당첨 번호에 중복된 숫자가 있을 때 예외 발생")
        void validateWinningNumbers_duplicateNumbers() {
            String input = "1,2,3,4,5,5";
            assertThatThrownBy(() -> Validation.validateWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }

        @Test
        @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있을 때 예외 발생")
        void validateWinningNumbers_outOfRangeNumbers() {
            String input = "0,2,3,4,5,6";
            assertThatThrownBy(() -> Validation.validateWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        @Test
        @DisplayName("당첨 번호에 숫자가 아닌 값이 있을 때 예외 발생")
        void validateWinningNumbers_notANumber() {
            String input = "1,2,3,4,5,a";
            assertThatThrownBy(() -> Validation.validateWinningNumbers(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    @Nested
    @DisplayName("validateBonusNumber 메서드 테스트")
    class ValidateBonusNumberTest {

        @Test
        @DisplayName("보너스 번호가 1-45 범위 내이고 당첨 번호와 중복되지 않을 때 성공")
        void validateBonusNumber_success() {
            String input = "7";
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            int bonus = Validation.validateBonusNumber(input, winningNumbers);
            assertThat(bonus).isEqualTo(7);
        }

        @Test
        @DisplayName("보너스 번호가 1보다 작을 때 예외 발생")
        void validateBonusNumber_lessThanOne() {
            String input = "0";
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            assertThatThrownBy(() -> Validation.validateBonusNumber(input, winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        @Test
        @DisplayName("보너스 번호가 45보다 클 때 예외 발생")
        void validateBonusNumber_greaterThanFortyFive() {
            String input = "46";
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            assertThatThrownBy(() -> Validation.validateBonusNumber(input, winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        @Test
        @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생")
        void validateBonusNumber_duplicateWithWinningNumbers() {
            String input = "3";
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            assertThatThrownBy(() -> Validation.validateBonusNumber(input, winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        @Test
        @DisplayName("보너스 번호가 숫자가 아닐 때 예외 발생")
        void validateBonusNumber_notANumber() {
            String input = "a";
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            assertThatThrownBy(() -> Validation.validateBonusNumber(input, winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    @Nested
    @DisplayName("validateLottoNumbers 메서드 테스트")
    class ValidateLottoNumbersTest {

        @Test
        @DisplayName("로또 번호가 6개이고 중복되지 않으며 1-45 범위일 때 성공")
        void validateLottoNumbers_success() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
            Validation.validateLottoNumbers(numbers);
            assertThat(true).isTrue();
        }

        @Test
        @DisplayName("로또 번호가 6개가 아닐 때 예외 발생")
        void validateLottoNumbers_notSixNumbers() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5);
            assertThatThrownBy(() -> Validation.validateLottoNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        @Test
        @DisplayName("로또 번호에 중복된 숫자가 있을 때 예외 발생")
        void validateLottoNumbers_duplicateNumbers() {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
            assertThatThrownBy(() -> Validation.validateLottoNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

        @Test
        @DisplayName("로또 번호에 범위를 벗어난 숫자가 있을 때 예외 발생")
        void validateLottoNumbers_outOfRangeNumbers() {
            List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);
            assertThatThrownBy(() -> Validation.validateLottoNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
