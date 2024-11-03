package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberValidateTest {

    WinningNumberValidate winningNumberValidate = new WinningNumberValidate();

    @Test
    @DisplayName("당첨번호_예외처리_테스트")
    void WinningNumberValidateTest() {
        String input = "1,2,3,4,5,6";
        winningNumberValidate.validate(input);
    }

    @Test
    @DisplayName("당첨번호_예외처리_빈칸_테스트")
    void WinningNumberBlankTest() {
        String input = "";
        assertThatThrownBy(() -> winningNumberValidate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호_예외처리_입력값_개수_테스트")
    void WinningNumberCheckSizeTest() {
        String inputOver = "1,2,3,4,5,6,7";
        String inputUnder = "1,2,3,4,5";

        assertThatThrownBy(() -> winningNumberValidate.validate(inputOver))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> winningNumberValidate.validate(inputUnder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호_예외처리_입력값_중복_테스트")
    void WinningNumberCheckDuplicateTest() {
        String input = "1,2,3,4,5,5";
        assertThatThrownBy(() -> winningNumberValidate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호_예외처리_입력값_자료형_테스트")
    void WinningNumberCheckTypeTest() {
        String input = "1,2,3,4,5,String";
        assertThatThrownBy(() -> winningNumberValidate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호_예외처리_입력값_범위_테스트")
    void WinningNumberCheckRangeTest() {
        String input = "1,2,3,4,5,100";
        assertThatThrownBy(() -> winningNumberValidate.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}