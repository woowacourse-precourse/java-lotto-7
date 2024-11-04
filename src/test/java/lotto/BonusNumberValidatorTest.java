package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
public class BonusNumberValidatorTest {
    @Test
    public void testValidBonusNumber() {
        String bonusNumber = "7";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> BonusNumberValidator.validate(bonusNumber, winningNumbers));
    }
    @Test
    public void testBonusNumberMatchingWinningNumber() {
        String bonusNumber = "5";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BonusNumberValidator.validate(bonusNumber, winningNumbers)
        );
        assertEquals("[ERROR] bonus 숫자는 당첨 번호와 달라야합니다.", exception.getMessage());
    }
    @Test
    public void testInvalidBonusNumber() {
        String bonusNumber = "-5";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BonusNumberValidator.validate(bonusNumber, winningNumbers)
        );
        assertEquals("[ERROR] 로또 번호는 1에서 45 사이입니다.", exception.getMessage());
    }
    @Test
    public void testInvalidBonusNumberFormat() {
        String bonusNumber = "abc";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BonusNumberValidator.validate(bonusNumber, winningNumbers)
        );
        assertEquals("[ERROR] int 범위 숫자만 입력해 주세요.(원 단위)", exception.getMessage());
    }

}

