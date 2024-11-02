package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersViewTest {
    private final InputView view = new WinningNumbersView();

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @DisplayName("숫자가 아닌 입력값 에러 테스트")
    @Test
    void validateNumericExceptionTest() {
        System.setIn(IoMock.consoleReadline("a,v,b"));

        assertThatThrownBy(() -> view.read())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈문자열 입력 시 에러 테스트")
    @Test
    void validateEmptyExceptionTest() {
        System.setIn(IoMock.consoleReadline("\n"));

        assertThatThrownBy(() -> view.read())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
