package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberViewTest {
    private final List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
    private final InputView view = new BonusNumberView(winningNumbers);

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @DisplayName("winngNumbers와 중복된 보너스 번호 입력 시 에러 테스트")
    @Test
    void validateDuplicateExceptionTest(){
        System.setIn(IoMock.consoleReadline("1"));

        assertThatThrownBy(() -> view.read())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 입력값 에러 테스트")
    @Test
    void validateNumericExceptionTest(){
        System.setIn(IoMock.consoleReadline("a"));

        assertThatThrownBy(() -> view.read())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈문자열 입력 시 에러 테스트")
    @Test
    void validateEmptryExceptionTest() {
        System.setIn(IoMock.consoleReadline("\n"));

        Assertions.assertThatThrownBy(() -> view.read())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
