package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.entity.WinningNumbers;
import lotto.enums.ErrorMessage;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
        Console.close();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("유효한 로또 구매 금액 입력 시 정상적으로 처리")
    void createWinningNumbersWithValidPurchaseAmount() {
        setInput("5000\n");
        int purchaseAmount = InputView.getPurchaseAmount();
        assertEquals(5000, purchaseAmount);
    }

    @Test
    @DisplayName("잘못된 로또 구매 금액 입력 시 예외 메시지 출력")
    void displayErrorMessageWhenPurchaseAmountIsInvalid() {
        setInput("300\n1000\n");
        InputView.getPurchaseAmount();
        String output = outputStreamCaptor.toString().trim();

        String[] messages = output.split("\n");
        String lastMessage = messages[messages.length - 2];
        assertEquals(ErrorMessage.INVALID_AMOUNT.getMessage(), lastMessage);
    }
}
