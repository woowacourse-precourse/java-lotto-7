package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BonusNumTest {

    private final bonus_num bonusNum = new bonus_num();

    @Test
    @DisplayName("유효한 보너스 번호 입력 테스트")
    public void testValidBonusNumber() {
        assertDoesNotThrow(() -> bonusNum.secondEx("15"), "보너스 번호가 45 이하의 숫자인 경우 예외가 발생하지 않아야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 45를 초과하는 경우 예외 발생 테스트")
    public void testBonusNumberExceedsLimit() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bonusNum.secondEx("46"); // 45 초과
        });
        assertEquals("[ERROR] 45이하의 숫자만 입력해주세요.", exception.getMessage(), "45를 초과하는 보너스 번호가 입력될 때 올바른 예외 메시지가 출력되어야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호에 숫자가 아닌 문자가 포함된 경우 예외 발생 테스트")
    public void testBonusNumberContainsNonNumeric() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bonusNum.secondEx("a");
        });
        assertEquals("[ERROR] 45이하의 숫자만 입력해주세요.", exception.getMessage(), "숫자가 아닌 문자가 포함된 보너스 번호가 입력될 때 올바른 예외 메시지가 출력되어야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호에 음수가 포함된 경우 예외 발생 테스트")
    public void testBonusNumberNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bonusNum.secondEx("-5");
        });
        assertEquals("[ERROR] 45이하의 숫자만 입력해주세요.", exception.getMessage(), "음수가 입력될 때 올바른 예외 메시지가 출력되어야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호에 공백이 포함된 경우 예외 발생 테스트")
    public void testBonusNumberWithWhitespace() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bonusNum.secondEx(" 5 ");
        });
        assertEquals("[ERROR] 45이하의 숫자만 입력해주세요.", exception.getMessage(), "공백이 포함된 보너스 번호가 입력될 때 올바른 예외 메시지가 출력되어야 합니다.");
    }
}
