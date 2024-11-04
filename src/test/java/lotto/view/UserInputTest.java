package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    private ByteArrayOutputStream getSystemSetOut() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        return outputStream;
    }


    @DisplayName("구입금액 입력 안내 메시지 확인")
    @Test
    void checkPurchaseAmountInputPrompt() {
        System.setIn(new ByteArrayInputStream("테스트 입력".getBytes()));
        ByteArrayOutputStream outputStream = getSystemSetOut();
        UserInput userInput = new UserInput();
        String successMessage = "구입금액을 입력해 주세요.";

        userInput.promptPurchaseAmountInput();

        assertEquals(successMessage + "\n", outputStream.toString());
    }

    @ParameterizedTest
    @DisplayName("구입금액 입력 함수 입력값 확인")
    @ValueSource(strings = {"7000", "adad", "1234"})
    void checkInputPurchaseAmount(String test) {
        System.setIn(new ByteArrayInputStream(test.getBytes()));
        UserInput userInput = new UserInput();

        assertEquals(test, userInput.promptPurchaseAmountInput());
    }

    @DisplayName("당첨 번호 입력 안내 메시지 확인")
    @Test
    void checkWinningNumberInputPrompt() {
        System.setIn(new ByteArrayInputStream("테스트 입력".getBytes()));
        ByteArrayOutputStream outputStream = getSystemSetOut();
        UserInput userInput = new UserInput();
        String successMessage = "\n당첨 번호를 입력해 주세요.";

        userInput.promptWinningNumberInput();

        assertEquals(successMessage + "\n", outputStream.toString());
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 입력 함수 입력값 확인")
    @ValueSource(strings = {"1,2,3,4,5,6", "adad", "1234"})
    void checkInputWinningNumber(String test) {
        System.setIn(new ByteArrayInputStream(test.getBytes()));
        UserInput userInput = new UserInput();

        assertEquals(test, userInput.promptWinningNumberInput());
    }

    @DisplayName("보너스 번호 입력 안내 메시지 확인")
    @Test
    void checkBonusNumberInputPrompt() {
        System.setIn(new ByteArrayInputStream("테스트 입력".getBytes()));
        ByteArrayOutputStream outputStream = getSystemSetOut();
        UserInput userInput = new UserInput();
        String successMessage = "\n보너스 번호를 입력해 주세요.";

        userInput.promptBonusNumberInput();

        assertEquals(successMessage + "\n", outputStream.toString());
    }

    @ParameterizedTest
    @DisplayName("보너스 번호 입력 함수 입력값 확인")
    @ValueSource(strings = {"7", "adad", "1234"})
    void checkInputBonusNumber(String test) {
        System.setIn(new ByteArrayInputStream(test.getBytes()));
        UserInput userInput = new UserInput();

        assertEquals(test, userInput.promptBonusNumberInput());
    }
}
