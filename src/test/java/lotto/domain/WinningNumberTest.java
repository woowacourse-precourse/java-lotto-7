package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {
    @Test
    @DisplayName("범위 검증 테스트")
    public void winningNumberRangeTest() {
        //given
        String input1 = "-1,2,3,4,5,6";
        String input2 = "46,2,3,4,5,6";

        //expect
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(input1));
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(input2));
    }
    @Test
    @DisplayName("중복 검증 테스트")
    public void winningNumberDuplicationTest() {
        //given
        String input = "1,1,2,3,4,5";

        //expect
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(input));
    }
    @Test
    @DisplayName("크기 검증 테스트")
    public void winningNumberTest() {
        //given
        String input = "1,2,3,4,5,6,7";

        //expect
        assertThrows(IllegalArgumentException.class, () -> new WinningNumber(input));
    }
}