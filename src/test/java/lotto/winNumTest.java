package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class winNumTest {

    @Test
    @DisplayName("당첨 번호 6개가 아닌 입력 시 예외 발생 테스트")
    public void testInvalidNumberOfWinNumbers() {
        Win_Num winNum = new Win_Num();
        String[] invalidInput = {"5", "12", "23", "34"};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            winNum.putNumEx(invalidInput);
        });

        assertEquals("[ERROR]당첨 숫자 6개를 입력해주세요.", exception.getMessage(), "당첨 번호가 6개가 아닌 경우 올바른 예외 메시지가 출력되어야 합니다.");
    }

    @Test
    @DisplayName("45 이상의 숫자 입력 시 예외 발생 테스트")
    public void testWinNumberOutOfRange() {
        Win_Num winNum = new Win_Num();
        String[] invalidInput = {"5", "12", "23", "46", "34", "41"};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            winNum.putNumEx2(invalidInput);
        });

        assertEquals("[ERROR]45이하의 당첨 숫자 6개를 입력해주세요.", exception.getMessage(), "45 이상의 숫자가 포함된 경우 올바른 예외 메시지가 출력되어야 합니다.");
    }

    @Test
    @DisplayName("중복된 숫자 입력 시 예외 발생 테스트")
    public void testDuplicateWinNumbers() {
        Win_Num winNum = new Win_Num();
        List<Integer> duplicateWinList = Arrays.asList(5, 12, 23, 23, 34, 41);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            winNum.putNumEx3(duplicateWinList);
        });

        assertEquals("[ERROR]중복되지 않은 당첨 숫자 6개를 입력해주세요.", exception.getMessage(), "중복된 숫자가 포함된 경우 올바른 예외 메시지가 출력되어야 합니다.");
    }
}