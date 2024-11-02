package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        System.setIn(originalIn); // 테스트를 마치면 입력 버퍼를 flush
        System.setOut(originalOut); // 테스트를 마치면 출력 버퍼를 flush
        Console.close();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }


    @Test
    @DisplayName("구입 금액이 1000원 단위로 입력되지 않으면 예외 메세지 출력")
    void shouldDisplayErrorMessageForInvalidPurchaseAmount() {
        // Given
        String invalidAmount = "5001\n5000\n";
        setInput(invalidAmount);

        // When(doesnt throw exception. just print error message)
        InputView.getPurchaseAmount();

        String output = outputStreamCaptor.toString().trim();

        // Then
        String[] messages = output.split("\n");
        String lastMessage = messages[messages.length - 2]; // 마지막 메시지만 검증

        // Then
        assertEquals(ErrorMessage.INVALID_AMOUNT.getMessage(), lastMessage);
    }

    @Test
    @DisplayName("올바른 구입 금액 입력 테스트")
    void shouldReturnCorrectPurchaseAmount() {
        // Given
        setInput("5000"); // 1000원 단위

        // When
        int purchaseAmount = InputView.getPurchaseAmount();

        // Then
        assertEquals(5000, purchaseAmount);
    }

    @Test
    @DisplayName("올바른 당첨 번호 입력 테스트")
    void shouldReturnCorrectWinningNumbers() {
        // Given
        setInput("1,2,3,4,5,6");

        // When
        List<Integer> winningNumbers = InputView.getWinningNumbers();

        // Then
        assertEquals(LottoConstants.LOTTO_NUMBERS_COUNT.getValue(), winningNumbers.size());
        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningNumbers);
    }
}
