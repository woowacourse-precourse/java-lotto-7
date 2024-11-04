package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UserInputControllerTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    private void setByteArrayInputStream(String input) {
        String test = input;
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

    @ParameterizedTest
    @DisplayName("구매 금액 정수값 아닌 값 예외 확인")
    @ValueSource(strings = {"0.1000", "천원", "one"})
    void checkInputNotIntegerPurchaseError(String test) {
        setByteArrayInputStream(test);
        UserInputController userInputController = new UserInputController();

        assertThatThrownBy(() -> userInputController.purchaseAmountInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수값이 아닌 값이 들어왔습니다.");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 정수값이 아닌 값 예외 확인")
    @ValueSource(strings = {"1000\n1,2,3.3,4,5,6\n", "1000\n1,2,,4,5,6\n", "1000\n1,2,삼,4,5,6\n"})
    void checkInputNotIntegerWinningNumberError(String test) {
        setByteArrayInputStream(test);
        UserInputController userInputController = new UserInputController();

        assertThatThrownBy(() -> userInputController.winningLottoInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수값이 아닌 값이 들어왔습니다.");
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 정수값이 아닌 값 예외 확인")
    @ValueSource(strings = {"1000\n1,2,3,4,5,6\n3.3\n", "1000\n1,2,3,4,5,6\n칠\n", "1000\n1,2,3,4,5,6\nhi\n"})
    void checkInputNotIntegerBonusNumberError(String test) {
        setByteArrayInputStream(test);
        UserInputController userInputController = new UserInputController();

        assertThatThrownBy(() -> userInputController.winningLottoInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수값이 아닌 값이 들어왔습니다.");
    }

    @ParameterizedTest
    @DisplayName("정상 동작 확인")
    @ValueSource(strings = {"1000\n1,2,3,4,5,6\n7\n", "10000\n1,2,3,4,5,6\n9\n", "1000\n1,10,16,18,30,40\n7\n"})
    void checkInputController(String test) {
        setByteArrayInputStream(test);
        UserInputController userInputController = new UserInputController();

        assertDoesNotThrow(() -> {
            userInputController.purchaseAmountInput();
            userInputController.winningLottoInput();
        });
    }
}
