package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @DisplayName("로또 구매금액이 빈 값일 시 예외가 발생한다.")
    @Test
    void 구입금액이_빈_값일_시_예외처리() {
        String input = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedPurchaseAmount(input));
        assertEquals("[ERROR]구입금액이 입력되지 않았습니다.", exception.getMessage());
    }

    @DisplayName("로또 구매금액이 음수일 시 예외가 발생한다.")
    @Test
    void 구입금액이_음수일_시_예외처리() {
        String input = "-8000";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedThousandUnitAmount(input));
        assertEquals("[ERROR]구입 금액은 양수여야 합니다.", exception.getMessage());
    }

    @DisplayName("로또 구매금액에 문자열이 포함될 시 예외가 발생한다.")
    @Test
    void 구입금액에_문자열이_포함될_시_예외처리() {
        String input = "6000a";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedThousandUnitAmount(input));
        assertEquals("[ERROR]구입 금액은 숫자여야 합니다.", exception.getMessage());
    }

    @DisplayName("로또 구매금액이 1,000원 단위로 나눠지지 않을 시 예외가 발생한다.")
    @Test
    void 구입금액이_1000원_단위가_아닐_시_예외처리() {
        String input = "6100";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedThousandUnitAmount(input));
        assertEquals("[ERROR]구입 금액은 1,000원 단위여야 합니다.", exception.getMessage());
    }

    @DisplayName("당첨 번호가 1에서 45 사이의 범위를 벗어나거나 중복되는 경우 예외가 발생한다.")
    @Test
    void 당첨번호가_1에서_45_범위를_벗어날_시_예외처리() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 48, 1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedWinnigNumbers(winningNumbers));
        assertEquals("[ERROR]당첨 번호는 1에서 45 사이여야 합니다.", exception.getMessage());
    }

    @DisplayName("당첨 번호의 값이 중복될 시 예외가 발생한다.")
    @Test
    void 당첨번호_값이_중복될_시_예외처리() {
        List<Integer> winningNumbers = Arrays.asList(1, 1, 3, 4, 42, 1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedWinnigNumbers(winningNumbers));
        assertEquals("[ERROR]당첨 번호는 중복될 수 없습니다.", exception.getMessage());
    }

    @DisplayName("당첨 번호가 6개가 아닐 시 예외가 발생한다.")
    @Test
    void 당첨번호_값이_6개가_아닐_시_예외처리() {
        List<Integer> winningNumbers = Arrays.asList(1, 3, 4, 42, 1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validatedWinnigNumbers(winningNumbers));
        assertEquals("[ERROR]당첨 번호는 6개여야 합니다.", exception.getMessage());
    }

    @DisplayName("당첨 번호 5개의 쉼표로 구분되지 않는 경우 예외가 발생한다.")
    @Test
    void 당첨번호가_5개의_쉼표로_구분되지_않을_시_예외처리() {
        String winningNumbers = "1,2,3,4,11";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Validation.validateWinningNumberFormat(winningNumbers));
        assertEquals("[ERROR]당첨 번호는 6개의 쉼표로 구분되어야 합니다.", exception.getMessage());
    }

}