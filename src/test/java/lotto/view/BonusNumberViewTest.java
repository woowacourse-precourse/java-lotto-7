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
        System.setIn(IoMock.consoleReadLine("1"));

        assertThatThrownBy(() -> view.read("보너스 번호를 입력해 주세요."))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 입력값 에러 테스트")
    @Test
    void validateNumericExceptionTest(){
        System.setIn(IoMock.consoleReadLine("a"));

        assertThatThrownBy(() -> view.read("보너스 번호를 입력해 주세요."))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈문자열 입력 시 에러 테스트")
    @Test
    void validateEmptryExceptionTest() {
        System.setIn(IoMock.consoleReadLine("\n"));

        Assertions.assertThatThrownBy(() -> view.read("보너스 번호를 입력해 주세요."))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
